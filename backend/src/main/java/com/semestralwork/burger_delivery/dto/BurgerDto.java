package com.semestralwork.burger_delivery.dto;

import com.semestralwork.burger_delivery.domain.ingredient.Ingredient;

import java.util.List;

public class BurgerDto {

    private String burgerName;

    List<Ingredient> ingredients;

    public BurgerDto() {
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "BurgerDto{" +
                "burgerName='" + burgerName + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
