package com.semestralwork.burger_delivery.domain.burger;

import com.semestralwork.burger_delivery.domain.ingredient.Ingredient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long burgerId;

    @Column(length = 50)
    private String burgerName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ingredient_fk", joinColumns = @JoinColumn(name = "ingredientId"),
            inverseJoinColumns = @JoinColumn(name = "burgerId"))
    List<Ingredient> ingredients;

    public Burger() {
    }

    public Burger(String burgerName, List<Ingredient> ingredients) {
        this.burgerName = burgerName;
        this.ingredients = ingredients;
    }

    public Long getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(Long burgerId) {
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
