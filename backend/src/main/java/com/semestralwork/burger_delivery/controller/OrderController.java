package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CreateOrderDto;
import com.semestralwork.burger_delivery.exception.CustomException;
import com.semestralwork.burger_delivery.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<DeliveryOrder>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/create-order", method = RequestMethod.POST)
    public ResponseEntity<DeliveryOrder> createOrder(@RequestBody CreateOrderDto createOrderDto) throws CustomException {
        orderService.createOrder(createOrderDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/order-delivered", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> orderDelivered(@RequestParam Long orderId){
        return new ResponseEntity<HttpStatus>(orderService.orderDelivered(orderId), HttpStatus.OK);
    }

}
