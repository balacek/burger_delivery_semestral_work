package com.semestralwork.burger_delivery.domain.adress;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adressId;

    @NotNull
    @Column(length = 100)
    private String city;

    @NotNull
    @Column(length = 100)
    private String street;

    @NotNull
    @Column(length = 15)
    private String postalCode;

    public Adress() {
    }

    public Adress(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return Objects.equals(getAdressId(), adress.getAdressId()) &&
                Objects.equals(getCity(), adress.getCity()) &&
                Objects.equals(getStreet(), adress.getStreet()) &&
                Objects.equals(getPostalCode(), adress.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdressId(), getCity(), getStreet(), getPostalCode());
    }
}
