package com.endava.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Ingredient {
    private String name;
    private double price;
    private double amount;
    private double maxAmountUsedInCoffee;

    public double getMaxAmountUsedInCoffee() {
        return maxAmountUsedInCoffee;
    }

    public Ingredient(String name, double price, double amount, double maxAmountUsedInCoffee) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.maxAmountUsedInCoffee = maxAmountUsedInCoffee;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", maxAmountUsedInCoffee=" + maxAmountUsedInCoffee +
                "}\n";
    }

}
