package com.semestralwork.burger_delivery.domain.ingredient;

import com.semestralwork.burger_delivery.domain.burger.Burger;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;

    @NotNull
    @Column
    private BigDecimal price;

    @NotNull
    @Column(length = 150)
    private String type;

    @ManyToMany(mappedBy = "ingredients")
    List<Burger> burgers;

    public Ingredient() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getIngredientId() == that.getIngredientId() &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getBurgers(), that.getBurgers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredientId(), getPrice(), getType(), getBurgers());
    }
}
