package com.semestralwork.burger_delivery.dto;

import com.semestralwork.burger_delivery.domain.adress.Adress;
import com.semestralwork.burger_delivery.domain.burger.Burger;
import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.enums.ORDERSTATE;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long orderId;

    private ORDERSTATE orderstate;

    private BigDecimal totalPrice;

    private Adress adress;

    private List<Burger> burgers;

    public OrderDto(DeliveryOrder deliveryOrder) {
        this.orderId = deliveryOrder.getOrderId();
        this.orderstate = deliveryOrder.getOrderstate();
        this.totalPrice = deliveryOrder.getTotalPrice();
        this.adress = deliveryOrder.getAdress();
        this.burgers = deliveryOrder.getBurgers();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ORDERSTATE getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(ORDERSTATE orderstate) {
        this.orderstate = orderstate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }
}
