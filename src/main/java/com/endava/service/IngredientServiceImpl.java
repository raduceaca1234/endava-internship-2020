package com.endava.service;

import com.endava.model.Ingredient;
import com.endava.model.InventoryProduct;
import com.endava.repository.IngredientRepoImpl;
import com.endava.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{

    @Autowired
    IngredientRepoImpl ingredientRepo;

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public boolean checkStocksOfIngredients() {
        List<InventoryProduct> ingredients = (List<InventoryProduct>) inventoryRepository.findAll();
        for(InventoryProduct ingredient:ingredients){
            if(ingredient.getQuantity()==0 || ingredient.getQuantity() < 4)
                return false;
        }
        return true;
    }

    public List<InventoryProduct> getRunLowOnIngredients(){
        List<InventoryProduct> ingredients = new ArrayList<>();
        for(InventoryProduct ingredient:inventoryRepository.findAll()) {
            if (ingredient.getQuantity() == 0 || ingredient.getQuantity() < 4)
                ingredients.add(ingredient);
        }
        return ingredients;
    }

    public double getAmountByName(String name){
        return inventoryRepository.findByType(name).getQuantity();
    }

    public double getPriceByName(String name){
        return ingredientRepo.getPriceByName(name);
    }

    public void decreaseAmountByName(String name, double amount) {
        inventoryRepository.decreaseAmount(name,(int)amount);
        ingredientRepo.decreaseAmountByName(name,amount);
    }

    public Ingredient getIngredient(String name){
        return ingredientRepo.getIngredient(name);
    }

    @Override
    public String toString() {
        return inventoryRepository.findAll().toString();
    }

    public List<InventoryProduct> getAllInventory(){
        return (List<InventoryProduct>) inventoryRepository.findAll();
    }
}
