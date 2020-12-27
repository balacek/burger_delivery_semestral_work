package com.semestralwork.burger_delivery.domain.customer;

import com.semestralwork.burger_delivery.domain.order.DeliveryOrder;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column
    private boolean allowNewsletters;

    @OneToMany(targetEntity = DeliveryOrder.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_fk", referencedColumnName = "customerId")
    private List<DeliveryOrder> orders;

    public Customer() {
    }

    public boolean isAllowNewsletters() {
        return allowNewsletters;
    }

    public void setAllowNewsletters(boolean allowNewsletters) {
        this.allowNewsletters = allowNewsletters;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return isAllowNewsletters() == customer.isAllowNewsletters() &&
                Objects.equals(getCustomerId(), customer.getCustomerId()) &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getSurname(), customer.getSurname()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getPassword(), customer.getPassword()) &&
                getCustomerType() == customer.getCustomerType() &&
                Objects.equals(getOrders(), customer.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getName(), getSurname(), getEmail(), getPhone(), getPassword(), getCustomerType(), isAllowNewsletters(), getOrders());
    }
}
