package com.endava.repository;

import com.endava.model.Coffee;

public interface CoffeeRepo {
    double getPriceByName(String name);

    Coffee getCoffee(String name);
}
