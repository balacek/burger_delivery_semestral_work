package com.semestralwork.burger_delivery.controller;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.dto.CreateOrderDto;
import com.semestralwork.burger_delivery.exception.CustomException;
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

    @RequestMapping(value = "/order-detail", method = RequestMethod.GET)
    public ResponseEntity<DeliveryOrder> getDeliveryOrderById(@RequestParam String id){
        return new ResponseEntity<DeliveryOrder>(orderService.getDeliveryOrderById(id).orElse(null), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/create-order", method = RequestMethod.POST)
    public ResponseEntity<DeliveryOrder> createOrder(@RequestBody CreateOrderDto createOrderDto) throws CustomException {
        throw new CustomException("ss");
       // orderService.createOrder(createOrderDto);

       // return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/order-delivered", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> orderDelivered(@RequestParam Long orderId){
        return new ResponseEntity<HttpStatus>(orderService.orderDelivered(orderId), HttpStatus.OK);
    }

}
