package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.commons.validator.routines.EmailValidator;

import javax.transaction.RollbackException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional(rollbackOn = Exception.class)
    public CustomerDto registerCustomer(CustomerDto customerDto) throws CustomException {
        customerExistsRegistration(customerDto.getEmail());
        validateEmail(customerDto.getEmail());

        Customer customer = new Customer();
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

    private void customerExistsRegistration(String email) {
        Optional<Customer> customerByEmail = customerRepository.findCustomerByEmail(email);
        if (customerByEmail.isPresent())
            throw new CustomException("Customer with this email already exists!");
    }

    private Customer getCustomer(String email) throws CustomException {
        return customerRepository.findCustomerByEmail(email).orElseThrow(() -> new CustomException("Customer does not exists!"));
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public List<DeliveryOrder> getCustomerOrders(String email) {
        return getCustomer(email).getOrders();
    }
}
