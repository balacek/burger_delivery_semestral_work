package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.apache.commons.validator.routines.EmailValidator;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerDto customerDto) throws CustomException {
        validateEmail(customerDto.getEmail());

        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setPassword(new BCryptPasswordEncoder().encode(customerDto.getPassword()));
        customer.setAllowNewsletters(customerDto.isAllowNesletter());
        customer.setCustomerType(CUSTOMERTYPE.ADMINISTATOR);

        customerRepository.save(customer);
        return customer;
    }

    private void validateEmail(String email){
        if(!EmailValidator.getInstance().isValid(email))
            throw new CustomException("Email in registration is not valid");
    }
}
