package com.semestralwork.burger_delivery.dto;

import com.semestralwork.burger_delivery.domain.customer.Customer;

public class CustomerDto {

    private Customer customer;


    public CustomerDto(Customer customer) {
        this.customer = customer;
    }

    public CustomerDto() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
