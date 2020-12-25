package com.semestralwork.burger_delivery.domain.customer;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    @Column(length = 30)
    private String name;

    @NotNull
    @Column(length = 30)
    private String surname;

    @Column(length = 50)
    private String email;

    @NotNull
    @Column
    private BigDecimal phone;

    @Column
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private CUSTOMERTYPE customerType;

    @OneToMany(targetEntity = DeliveryOrder.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_fk", referencedColumnName = "customerId")
    private List<DeliveryOrder> orders;

    public Customer() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPhone() {
        return phone;
    }

    public void setPhone(BigDecimal phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CUSTOMERTYPE getCustomertype() {
        return customerType;
    }

    public void setCustomertype(CUSTOMERTYPE customerType) {
        this.customerType = customerType;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public CUSTOMERTYPE getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CUSTOMERTYPE customerType) {
        this.customerType = customerType;
    }

    public List<DeliveryOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<DeliveryOrder> orders) {
        this.orders = orders;
    }
}
