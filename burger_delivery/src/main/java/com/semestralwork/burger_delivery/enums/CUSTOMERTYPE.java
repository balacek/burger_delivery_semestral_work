package com.semestralwork.burger_delivery.enums;

public enum CUSTOMERTYPE {

    ADMINISTATOR("ADMINISTATOR"),
    PERSON("PERSON");

    public final String label;

    private CUSTOMERTYPE(String label) {
        this.label = label;
    }
}
