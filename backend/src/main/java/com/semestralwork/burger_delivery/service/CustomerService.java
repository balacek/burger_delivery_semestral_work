package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.commons.validator.routines.EmailValidator;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional(rollbackOn = Exception.class)
    public CustomerDto registerCustomer(CustomerDto customerDto) throws CustomException {
        Customer customer = customerExistsRegistration(customerDto.getEmail());
        validateEmail(customerDto.getEmail());

        if(customer == null){
            customer = new Customer();
        }
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        customer.setAllowNewsletters(customerDto.isAllowNesletter());
        customer.setCustomerType(CUSTOMERTYPE.PERSON);

        customerRepository.save(customer);
        return new CustomerDto(customer);
    }

    public Customer customerDetail(String email) {
        if (StringUtils.isNotBlank(email))
            return customerRepository.findCustomerByEmail(email).orElse(null);
        return null;
    }

    private void validateEmail(String email) {
        if (!EmailValidator.getInstance().isValid(email))
            throw new CustomException("Email in registration is not valid");
    }

    private Customer customerExistsRegistration(String email) {
        return customerRepository.findCustomerByEmail(email).orElse(null);
    }

    public Customer getCustomer(String email) throws CustomException {
        return customerRepository.findCustomerByEmail(email).orElseThrow(() -> new CustomException("Customer does not exists!"));
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public List<DeliveryOrder> getCustomerOrders(String email) {
        return getCustomer(email).getOrders();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public Optional<Customer> getCustomerByPhoneAndEmail(BigDecimal phone, String email) {
        return customerRepository.getCustomerByPhoneAndEmail(Long.parseLong(phone.toString()), email);
    }

    public List<DeliveryOrder> getCustomerOrders(Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer.getOrders();
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
