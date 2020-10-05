package com.endava.model;

import com.endava.model.ingredient.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoffeeShop {

    Expresso expresso;
    BlackCoffee blackCoffee;
    BrownSugar brownSugar;
    Caramel caramel;
    Cinnamon cinnamon;
    Honey honey;
    MilkFoam milkFoam;
    SteamedMilk steamedMilk;
    Sugar sugar;

    public CoffeeShop() {
        expresso = new Expresso();
        blackCoffee = new BlackCoffee();
        brownSugar = new BrownSugar();
        caramel = new Caramel();
        cinnamon = new Cinnamon();
        honey = new Honey();
        milkFoam = new MilkFoam();
        steamedMilk = new SteamedMilk();
        sugar = new Sugar();
    }
}
