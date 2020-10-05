package com.endava.service;

import com.endava.model.InventoryProduct;

import java.util.List;

public interface IngredientService {
    boolean checkStocksOfIngredients();

    List<InventoryProduct> getRunLowOnIngredients();
}
