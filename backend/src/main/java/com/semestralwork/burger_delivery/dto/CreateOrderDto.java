package com.semestralwork.burger_delivery.dto;

import com.semestralwork.burger_delivery.domain.adress.Adress;

import java.math.BigDecimal;
import java.util.List;

public class CreateOrderDto {

    //Field if the customer is registred
    private Long customerId;

    //Field for not registred customer
    private String name;
    private String surname;
    private String email;
    private BigDecimal phone;

    //Adress for delivery
    private Adress adress;

    private List<BurgerDto> burgers;

    private boolean allowNews;

    public CreateOrderDto() {
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

    public boolean isAllowNews() {
        return allowNews;
    }

    public void setAllowNews(boolean allowNews) {
        this.allowNews = allowNews;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<BurgerDto> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<BurgerDto> burgers) {
        this.burgers = burgers;
    }

    @Override
    public String toString() {
        return "CreateOrderDto{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", adress=" + adress +
                ", burgers=" + burgers +
                ", allowNews=" + allowNews +
                '}';
    }
}
