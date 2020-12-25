package com.semestralwork.burger_delivery.domain.burger;

import com.semestralwork.burger_delivery.domain.ingredient.Ingredient;
import com.semestralwork.burger_delivery.domain.order.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int burgerId;

    @Column(length = 50)
    private String burgerName;

    @ManyToMany
    @JoinTable(name = "ingredient_fk", joinColumns = @JoinColumn(name = "ingredientId"),
            inverseJoinColumns = @JoinColumn(name = "burgerId"))
    List<Ingredient> ingredients;

    public Burger() {
    }

    public int getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(int burgerId) {
        this.burgerId = burgerId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Burger)) return false;
        Burger burger = (Burger) o;
        return getBurgerId() == burger.getBurgerId() &&
                Objects.equals(getBurgerName(), burger.getBurgerName()) &&
                Objects.equals(getIngredients(), burger.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBurgerId(), getBurgerName(), getIngredients());
    }
}
