package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.exception.CustomException;
import org.apache.commons.validator.ValidatorException;
import org.springframework.stereotype.Service;

import org.apache.commons.validator.routines.EmailValidator;

@Service
public class CustomerService {
    public Customer registerCustomer(CustomerDto customerDto) throws CustomException {
        throw new CustomException("ahoj");
    }

    private void validateEmail(String email){

        if(!EmailValidator.getInstance().isValid(email)){
            //throw new
        }
    }
}
