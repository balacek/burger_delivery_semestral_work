package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.controller.CustomerController;
import com.semestralwork.burger_delivery.domain.burger.Burger;
import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.ingredient.Ingredient;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrderRepository;
import com.semestralwork.burger_delivery.dto.CreateOrderDto;
import com.semestralwork.burger_delivery.enums.ORDERSTATE;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class);

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    @Autowired
    CustomerService customerService;

    public List<DeliveryOrder> getAllOrders(){
        return deliveryOrderRepository.findAll();
    }

    public Optional<DeliveryOrder> getDeliveryOrderById(String id){
        return deliveryOrderRepository.findById(Long.parseLong(id));
    }

    @Transactional(rollbackOn = Exception.class)
    public void createOrder(CreateOrderDto createOrderDto) throws CustomException {
        checkIfOrderContainsCustomerValues(createOrderDto);
        checkIfOrderContainsAdressValues(createOrderDto);

        Customer customer = returnCustomerByIdOrEmailToConnectOrder(createOrderDto);

        DeliveryOrder deliveryOrder = new DeliveryOrder(getTotalPrice(createOrderDto), createOrderDto.getAdress());

        List<Burger> burgerList = new ArrayList<>();

        createOrderDto.getBurgers().forEach(burgerObject -> {
            List<Ingredient> list = burgerObject.getIngredients().stream()
                    .map(Ingredient::new).collect(Collectors.toList());
            Burger burger =  new Burger(burgerObject.getBurgerName(), list);
            burgerList.add(burger);
        });

        deliveryOrder.setBurgers(burgerList);
        deliveryOrder.setOrderstate(ORDERSTATE.PENDING);

        //sign an order to customer if some customer already exist in DB
        if(customer != null) {
            List<DeliveryOrder> orders = customer.getOrders();
            orders.add(deliveryOrder);
            customer.setOrders(orders);
            customerService.saveCustomer(customer);
        }else{
            Customer customer1 = new Customer(createOrderDto.getPhone(), createOrderDto.getName(), createOrderDto.getSurname(),
                    createOrderDto.getEmail(),createOrderDto.isAllowNews());
            List<DeliveryOrder> orders = new ArrayList<>();
            orders.add(deliveryOrder);
            customer1.setOrders(orders);
            customerService.saveCustomer(customer1);
        }
    }

    private Customer returnCustomerByIdOrEmailToConnectOrder(CreateOrderDto createOrderDto){
        Customer customer = null;
        if(createOrderDto.getCustomerId() != null){
            customer = customerService.getCustomerById(createOrderDto.getCustomerId()).orElse(null);
        }else{
            if(createOrderDto.getPhone() != null && StringUtils.isNotBlank(createOrderDto.getEmail())){
                    customer = customerService
                            .getCustomerByPhoneAndEmail(createOrderDto.getPhone(), createOrderDto.getEmail())
                                .orElse(null);
            }
        }
        return customer;
    }

    private BigDecimal getTotalPrice(CreateOrderDto createOrderDto){
        long sum = createOrderDto.getBurgers()
                .stream().mapToLong(burger -> burger.getIngredients()
                        .stream().mapToLong(Ingredient::getPrice).sum()).sum();
        return new BigDecimal(sum);
    }

    private void checkIfOrderContainsCustomerValues(CreateOrderDto createOrderDto) throws CustomException{
        if(createOrderDto.getCustomerId() == null && (createOrderDto.getPhone() == null
                || StringUtils.isBlank(createOrderDto.getName()) || StringUtils.isBlank(createOrderDto.getSurname()))){
            throw new CustomException("Field for order regarding customers are not enough");
        }
    }

    private void checkIfOrderContainsAdressValues(CreateOrderDto createOrderDto) throws CustomException{
        if(createOrderDto.getAdress() != null){
            if(createOrderDto.getAdress().getCity() == null || createOrderDto.getAdress().getStreet() == null
                    || createOrderDto.getAdress().getPostalCode() == null){
                throw new CustomException("Field for order regarding customers are not enough");
            }
        }else{
            throw new CustomException("Field for order regarding adress are not valid");
        }
    }

    public List<DeliveryOrder> getCustomerOrders(Long customerId) {
        return customerService.getCustomerOrders(customerId);
    }

    @Transactional(rollbackOn = Exception.class)
    public HttpStatus orderDelivered(Long orderId) {
        DeliveryOrder deliveryOrder = deliveryOrderRepository.getOne(orderId);
        deliveryOrder.setOrderstate(ORDERSTATE.DELIVERED);
        deliveryOrderRepository.save(deliveryOrder);
        return HttpStatus.OK;
    }
}
