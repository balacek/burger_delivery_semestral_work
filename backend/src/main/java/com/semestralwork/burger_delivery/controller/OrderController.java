package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CreateOrderDto;
import com.semestralwork.burger_delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrder>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "customer-orders", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrder>> getCustomerOrders(@RequestParam Long customerId){
        return new ResponseEntity<List<DeliveryOrder>>(orderService.getCustomerOrders(customerId), HttpStatus.OK);
    }

    @RequestMapping(value = "/order-detail", method = RequestMethod.GET)
    public ResponseEntity<DeliveryOrder> getDeliveryOrderById(@RequestParam String id){
        return new ResponseEntity<DeliveryOrder>(orderService.getDeliveryOrderById(id).orElse(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/create-order", method = RequestMethod.POST)
    public ResponseEntity<DeliveryOrder> createOrder(@RequestBody CreateOrderDto createOrderDto){
        orderService.createOrder(createOrderDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
