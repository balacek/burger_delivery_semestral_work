package com.semestralwork.burger_delivery.dto;

import com.semestralwork.burger_delivery.domain.customer.Customer;
import com.semestralwork.burger_delivery.enums.CUSTOMERTYPE;
import com.semestralwork.burger_delivery.exception.CustomException;

import java.math.BigDecimal;

public class CustomerDto {

    private int id;

    private String name;

    private String surname;

    private String email;

    private BigDecimal phone;

    private String password;

    private Boolean allowNesletter;

    private CUSTOMERTYPE customerType;

    public CustomerDto() {
    }

    public CustomerDto(String name, String surname, String email, BigDecimal phone, String password, Boolean allowNesletter) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.allowNesletter = allowNesletter;
    }

    public CustomerDto(Customer customer) {
        if(customer == null){
            throw new CustomException("Customer is null in constructor if CustomerDto.java");
        }
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.allowNesletter = customer.getAllowNewsletters();
        this.customerType = customer.getCustomerType();
        this.id = Math.toIntExact(customer.getCustomerId());
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

    public Boolean isAllowNesletter() {
        return allowNesletter;
    }

    public void setAllowNesletter(Boolean allowNesletter) {
        this.allowNesletter = allowNesletter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CUSTOMERTYPE getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CUSTOMERTYPE customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", allowNesletter=" + allowNesletter +
                ", customerType=" + customerType +
                '}';
    }
}
