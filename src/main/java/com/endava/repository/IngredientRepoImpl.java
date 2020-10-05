package com.endava.repository;

import com.endava.model.Ingredient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class IngredientRepoImpl implements IngredientRepo {
    List<Ingredient> ingredients;

    public double getPriceByName(String name){
        for(Ingredient i:ingredients){
            if(i.getName().equals(name))
                return i.getPrice();
        }
        return 0;
    }

    public void decreaseAmountByName(String name, double amount){
        for(Ingredient ingredient:ingredients){
            if(ingredient.getName().equals(name))
                ingredient.setAmount(ingredient.getAmount()-amount);
        }
    }

    public Ingredient getIngredient(String name){
        for(Ingredient i:ingredients){
            if(i.getName().equals(name))
                return i;
        }

        return new Ingredient("",0, 0, 0);
    }

    public double getAmountByName(String name){
        for(Ingredient ingredient:ingredients) {
            if (ingredient.getName().equals(name))
                return ingredient.getAmount();
        }

        return 0;
    }

    public IngredientRepoImpl() {
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Expresso",1, 100, 2));
        ingredients.add(new Ingredient("Black Coffee",2, 100, 2));
        ingredients.add(new Ingredient("Steamed Milk",3, 100, 2));
        ingredients.add(new Ingredient("Milk Foam",2, 100, 2));
        ingredients.add(new Ingredient("Honey",3, 100, 3));
        ingredients.add(new Ingredient("Cinnamon",4, 100, 2));
        ingredients.add(new Ingredient("Sugar",1, 100, 3));
        ingredients.add(new Ingredient("Brown Sugar",2, 100, 3));
        ingredients.add(new Ingredient("Caramel",3, 100, 4));
    }

    @Override
    public String toString() {
        return "IngredientsRepo{" +
                "ingredients=" + ingredients +
                '}';
    }
}
