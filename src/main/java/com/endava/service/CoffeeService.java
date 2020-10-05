package com.endava.service;

import com.endava.exception.OrderException;
import com.endava.model.Coffee;
import com.endava.model.Ingredient;
import com.endava.model.ClientOrder;

import java.util.List;

public interface CoffeeService {
    Coffee createCoffee(List<Ingredient> recipe, String clientName);

    double getPriceByName(String name);

    Coffee getCoffee(String name);

    void addOrder(Coffee beverage, Integer quantity, String customerName, boolean pickup) throws OrderException;

    List<ClientOrder> getAll();
}
