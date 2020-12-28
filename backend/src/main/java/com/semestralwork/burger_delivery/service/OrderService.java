package com.semestralwork.burger_delivery.service;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;

    public List<DeliveryOrder> getAllOrders(){
        return deliveryOrderRepository.findAll();
    }
}
