package com.semestralwork.burger_delivery.domain.customer;

import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

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
    private CUSTOMERTYPE customertype;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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
        return customertype;
    }

    public void setCustomertype(CUSTOMERTYPE customertype) {
        this.customertype = customertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getSurname(), customer.getSurname()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getPassword(), customer.getPassword()) &&
                getCustomertype() == customer.getCustomertype();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getName(), getSurname(), getEmail(), getPhone(), getPassword(), getCustomertype());
    }
}
