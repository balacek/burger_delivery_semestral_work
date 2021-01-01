package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.burger.Burger;
import com.semestralwork.burger_delivery.domain.ingredient.Ingredient;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrderRepository;
import com.semestralwork.burger_delivery.dto.CreateOrderDto;
import com.semestralwork.burger_delivery.enums.ORDERSTATE;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

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

        //TODO CHECK TOTAL PRICE

        DeliveryOrder deliveryOrder = new DeliveryOrder(createOrderDto.getTotalPrice(), createOrderDto.getAdress());

        List<Burger> burgerList = new ArrayList<>();

        createOrderDto.getBurgers().forEach(burgerObject -> {
            List<Ingredient> list = burgerObject.getIngredients().stream()
                    .map(Ingredient::new).collect(Collectors.toList());
            Burger burger =  new Burger(burgerObject.getBurgerName(), list);
            burgerList.add(burger);
        });

        deliveryOrder.setBurgers(burgerList);
        deliveryOrder.setOrderstate(ORDERSTATE.PENDING);

        deliveryOrderRepository.save(deliveryOrder);
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

}
