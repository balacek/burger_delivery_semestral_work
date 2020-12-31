package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrder>> getAllOrders(){
        return new ResponseEntity<List<DeliveryOrder>>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/order-detail", method = RequestMethod.GET)
    public ResponseEntity<DeliveryOrder> getDeliveryOrderById(@RequestParam String id){
        return new ResponseEntity<DeliveryOrder>(orderService.getDeliveryOrderById(id).orElse(null), HttpStatus.OK);
    }

}
