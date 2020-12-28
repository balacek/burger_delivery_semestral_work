package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.exception.CustomException;
import com.semestralwork.burger_delivery.service.CustomerService;
import org.apache.commons.validator.ValidatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create-customer", method = RequestMethod.POST)
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) throws CustomException {
        return new ResponseEntity<CustomerDto>(customerService.registerCustomer(customerDto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer-detail", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> customerDetail(@RequestParam String email){
            customerService.customerDetail(email);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomer(){
      return customerService.getAll();
    }
}
