package com.semestralwork.burger_delivery.domain.ingredient;

import com.semestralwork.burger_delivery.domain.burger.Burger;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;

    @NotNull
    @Column
    private long price;

    @NotNull
    @Column(length = 150)
    private String type;

    public Ingredient() {
    }

    public Ingredient(Ingredient ingredient) {
        this.price = ingredient.price;
        this.type = ingredient.type;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(getIngredientId(), that.getIngredientId()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredientId(), getPrice(), getType());
    }
}
