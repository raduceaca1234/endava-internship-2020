package com.endava.repository;

import com.endava.model.Coffee;
import com.endava.model.Ingredient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class CoffeeRepoImpl implements CoffeeRepo {

    List<Coffee> coffees;

    public CoffeeRepoImpl() {
        this.coffees = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Expresso",1, 1, 2));
        coffees.add(new Coffee("Expresso",3, ingredients));
        ingredients.add(new Ingredient("Milk Foam",2, 1, 2));
        coffees.add(new Coffee("Machiatto",4,  ingredients));
        ingredients.add(new Ingredient("Steamed Milk",3, 1, 2));
        coffees.add(new Coffee("Coffee Latte",4, ingredients));
        coffees.add(new Coffee("Cappucino",5,ingredients));
        ingredients.add(new Ingredient("Cinnamon",4, 1, 2));
        ingredients.add(new Ingredient("Honey",3, 1, 3));
        coffees.add(new Coffee("Coffee Miel",4,ingredients));
    }

    @Override
    public String toString() {
        return "CoffeeRepo{" +
                "coffees=" + coffees +
                '}';
    }

    public double getPriceByName(String name){
        for(Coffee i:coffees){
            if(i.getName().equals(name))
                return i.getPrice();
        }

        return 0;

    }

    public Coffee getCoffee(String name){
        for(Coffee i:coffees){
            if(i.getName().equals(name)){
                return i;
            }
        }

        return null;
    }
}
