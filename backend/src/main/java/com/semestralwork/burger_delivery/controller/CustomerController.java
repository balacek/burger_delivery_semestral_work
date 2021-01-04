package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.domain.customer.CustomerRepository;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CustomerDto;
import com.semestralwork.burger_delivery.exception.CustomException;
import com.semestralwork.burger_delivery.service.CustomerService;
import org.apache.commons.validator.ValidatorException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer/create-customer", method = RequestMethod.POST)
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto customerDto) throws CustomException {
        return new ResponseEntity<CustomerDto>(customerService.registerCustomer(customerDto), HttpStatus.CREATED);
    }

    //can acces only via bearer token
    @RequestMapping(value = "/customer-detail", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> customerDetail(@RequestParam String email){
           return new ResponseEntity<CustomerDto>(new CustomerDto(customerService.customerDetail(email)), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/customers", method = RequestMethod.GET)
    public List<Customer> getCustomer(){
      return customerService.getAll();
    }


    @RequestMapping(value = "/customer-orders", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrder>> getCustomerOrders(@RequestParam String email) throws CustomException{
        return new ResponseEntity<List<DeliveryOrder>>(customerService.getCustomerOrders(email), HttpStatus.OK);
    }
}
