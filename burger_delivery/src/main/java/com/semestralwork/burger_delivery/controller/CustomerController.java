package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

   // @Autowired
   // private CustomerRepository customerRepository;

   /* @RequestMapping(value = "/save-customer", method = RequestMethod.POST)
    public Customer saveCustomer(@RequestBody CustomerDto customerDto){
        return customerRepository.save(customerDto.getCustomer());
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }*/
}
