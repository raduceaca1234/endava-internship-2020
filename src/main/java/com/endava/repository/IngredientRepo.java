package com.endava.repository;

import com.endava.model.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo  {
    double getPriceByName(String name);

    void decreaseAmountByName(String name, double amount);

    Ingredient getIngredient(String name);

    double getAmountByName(String name);
}
