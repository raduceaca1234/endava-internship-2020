package com.endava.service;

import com.endava.exception.OrderException;
import com.endava.model.ClientOrder;
import com.endava.model.Coffee;
import com.endava.model.Ingredient;
import com.endava.model.Recipe;
import com.endava.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    CoffeeRepoImpl coffeeRepo;

    @Autowired
    OrderOfUser orderOfUser;

    @Autowired
    IngredientRepoImpl ingredientRepo;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Coffee createCoffee(List<Ingredient> recipe, String clientName) {
        double price = 0;
        for (Ingredient ingredient:recipe){
            price += ingredient.getPrice()*ingredient.getAmount();
        }

        return new Coffee(clientName, price, recipe);
    }

    @Override
    public double getPriceByName(String name){
        return coffeeRepo.getPriceByName(name);

    }

    @Override
    public Coffee getCoffee(String name){
        return coffeeRepo.getCoffee(name);
    }

    @Override
    public String toString() {
        return coffeeRepo.toString();
    }

    @Override
    public void addOrder(Coffee beverage, Integer quantity, String customerName, boolean pickup) throws OrderException {
        List<Ingredient> ingredientList = beverage.getIngredients();
        for(Ingredient ingredient: ingredientList){
            if (ingredient.getAmount() > inventoryRepository.findByType(ingredient.getName()).getQuantity())
                throw new OrderException("Not enough supplies!");
        }
        orderOfUser.addOrder(new ClientOrder(beverage.getName(),customerName,beverage.getPrice(),pickup, quantity));
        orderRepository.save(new ClientOrder(beverage.getName(),customerName,beverage.getPrice(),pickup, quantity));
    }

    public void addOrderBrewing(Coffee beverage, Integer quantity, String customerName, boolean pickup) throws OrderException {
        orderOfUser.addOrder(new ClientOrder(beverage.getName(),customerName,beverage.getPrice(),pickup, quantity));
        orderRepository.save(new ClientOrder(beverage.getName(),customerName,beverage.getPrice(),pickup, quantity));
    }

    public List<Recipe> getAllRecipes(){
        return (List<Recipe>) recipeRepository.findAll();
    }

    public List<ClientOrder> getAll(){
        return orderOfUser.getAll();
    }
}
