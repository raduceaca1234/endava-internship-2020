package com.endava.view;

import com.endava.exception.OrderException;
import com.endava.model.*;
import com.endava.repository.OrderOfUser;
import com.endava.service.CoffeeServiceImpl;
import com.endava.service.IngredientServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UserInterface {

    @Autowired
    private CoffeeServiceImpl coffeeService;
    @Autowired
    private IngredientServiceImpl ingredientService;

    CoffeeShop coffeeShop = new CoffeeShop();

    private void printIngredients(){
        List<InventoryProduct> products = ingredientService.getAllInventory();
        for(InventoryProduct inventoryProduct :products)
            System.out.println(inventoryProduct.toString());
    }

    private double checkAmount(String name, double amount){
        Scanner scanner = new Scanner(System.in);
        while(amount > ingredientService.getAmountByName(name)){
            System.out.println("Give another value please \n >");
            amount = scanner.nextInt();
        }
        return amount;
    }

    private Coffee brewingClientCoffee() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? \n >");
        String clientName = scanner.nextLine();
        double amount;
        List<Ingredient> listOfIngredients = new ArrayList<>();
        while(true){
            printIngredients();
            int number = scanner.nextInt();
            System.out.println(number);
             switch (number){
                case 0:
                    System.out.println(listOfIngredients);
                    return coffeeService.createCoffee(listOfIngredients ,clientName);
                case 1:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount > ingredientService.getAmountByName(coffeeShop.getExpresso().getName())){
                        amount = checkAmount(coffeeShop.getExpresso().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getExpresso().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getExpresso().getName(),coffeeShop.getExpresso().getPrice(), amount,coffeeShop.getExpresso().getMaxAmount()));
                    break;
                case 2:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getBlackCoffee().getName())){
                        amount = checkAmount(coffeeShop.getBlackCoffee().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getBlackCoffee().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getBlackCoffee().getName(),coffeeShop.getBlackCoffee().getPrice(), amount, coffeeShop.getBlackCoffee().getMaxAmount()));
                    break;
                case 3:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getSteamedMilk().getName())){
                        amount = checkAmount(coffeeShop.getSteamedMilk().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getSteamedMilk().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getSteamedMilk().getName(),coffeeShop.getSteamedMilk().getPrice(), amount, coffeeShop.getSteamedMilk().getMaxAmount()));
                    break;
                case 4:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getMilkFoam().getName())){
                        amount = checkAmount(coffeeShop.getMilkFoam().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getMilkFoam().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getMilkFoam().getName(),coffeeShop.getMilkFoam().getPrice(), amount, coffeeShop.getMilkFoam().getMaxAmount()));
                    break;
                case 5:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getHoney().getName())){
                        amount = checkAmount(coffeeShop.getHoney().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getHoney().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getHoney().getName(),coffeeShop.getHoney().getPrice(), amount, coffeeShop.getHoney().getMaxAmount()));
                    break;
                case 6:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getCinnamon().getName())){
                        amount = checkAmount(coffeeShop.getCinnamon().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getCinnamon().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getCinnamon().getName(),coffeeShop.getCinnamon().getPrice(), amount, coffeeShop.getCinnamon().getMaxAmount()));
                    break;
                case 7:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getSugar().getName())){
                        amount = checkAmount(coffeeShop.getSugar().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getSugar().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getSugar().getName(),coffeeShop.getSugar().getPrice(), amount, coffeeShop.getSugar().getMaxAmount()));
                    break;
                case 8:

                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getBrownSugar().getName())){
                        amount = checkAmount(coffeeShop.getBrownSugar().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getBrownSugar().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getBrownSugar().getName(),coffeeShop.getBrownSugar().getPrice(), amount, coffeeShop.getBrownSugar().getMaxAmount()));
                    break;
                case 9:
                    System.out.println("What amount do you want? \n >");
                    amount = scanner.nextInt();
                    if(amount>ingredientService.getAmountByName(coffeeShop.getCaramel().getName())){
                        amount = checkAmount(coffeeShop.getCaramel().getName(), amount);
                    }
                    ingredientService.decreaseAmountByName(coffeeShop.getCaramel().getName(), amount);
                    listOfIngredients.add(new Ingredient(coffeeShop.getCaramel().getName(),coffeeShop.getCaramel().getPrice(), amount, coffeeShop.getCaramel().getMaxAmount()));
                    break;
            }
        }
    }

    private Coffee makeCustomerCoffee() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? \n >");
        String clientName = scanner.nextLine();
        int price = 0;
        List<Ingredient> listOfIngredients = new ArrayList<>();
        while(true){
            printIngredients();
            int number = scanner.nextInt();
            System.out.println(number);
            switch (number){
                case 0:
                    System.out.println(listOfIngredients);
                    return new Coffee(clientName,price,listOfIngredients);
                case 1:
                    price+= ingredientService.getPriceByName("Expresso");
                    ingredientService.decreaseAmountByName("Expresso",1);
                    listOfIngredients.add(ingredientService.getIngredient("Expresso"));
                    break;
                case 2:
                    price+= ingredientService.getPriceByName("Black Coffee");
                    ingredientService.decreaseAmountByName("Black Coffee",1);
                    listOfIngredients.add(ingredientService.getIngredient("Black Coffee"));
                    break;
                case 3:
                    price+= ingredientService.getPriceByName("Steamed Milk");
                    ingredientService.decreaseAmountByName("Steamed Milk",1);
                    listOfIngredients.add(ingredientService.getIngredient("Steamed Milk"));
                    break;
                case 4:
                    price+= ingredientService.getPriceByName("Milk Foam");
                    ingredientService.decreaseAmountByName("Milk Foam",1);
                    listOfIngredients.add(ingredientService.getIngredient("Milk Foam"));
                    break;
                case 5:
                    price+= ingredientService.getPriceByName("Honey");
                    ingredientService.decreaseAmountByName("Honey",1);
                    listOfIngredients.add(ingredientService.getIngredient("Honey"));
                    break;
                case 6:
                    price+= ingredientService.getPriceByName("Cinnamon");
                    ingredientService.decreaseAmountByName("Cinnamon",1);
                    listOfIngredients.add(ingredientService.getIngredient("Cinnamon"));
                    break;
                case 7:
                    price+= ingredientService.getPriceByName("Sugar");
                    ingredientService.decreaseAmountByName("Sugar",1);
                    listOfIngredients.add(ingredientService.getIngredient("Sugar"));
                    break;
                case 8:

                    price+= ingredientService.getPriceByName("Brown Sugar");
                    ingredientService.decreaseAmountByName("Brown Sugar",1);
                    listOfIngredients.add(ingredientService.getIngredient("Brown Sugar"));
                    break;
                case 9:
                    price+= ingredientService.getPriceByName("Caramel");
                    ingredientService.decreaseAmountByName("Caramel", 1);
                    listOfIngredients.add(ingredientService.getIngredient("Caramel"));
                    break;
            }
        }
    }

    private void printConsole(){
        System.out.println("Radu's Coffee! Choose your option: " +
                coffeeService.toString() +
                " or \n 6 create your own coffee! "+
                "\n 7 brew your coffee!" +
                "\n 8 check the stocks!"+
                "\n 9 print all recipes!");
    }

    public void checkIngredients () {
        if(!ingredientService.checkStocksOfIngredients())
        {
            System.out.println("The coffee shop is running low on some ingredients");
            List<InventoryProduct> ingredients = ingredientService.getRunLowOnIngredients();
            System.out.println("These are the ingredients: ");
            for (InventoryProduct ingredient:ingredients)
                System.out.println(ingredient.toString());
        }
    }

    public void run() throws OrderException, ClassNotFoundException {
        double price = 0;
        Scanner scanner = new Scanner(System.in);
        String userName;
        String choice;
        boolean isPickUp;
        OrderOfUser repo = new OrderOfUser();
        while(true){
            printConsole();
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println(option);
            switch (option){
                case 0:
                    return;
                case 1:
                    System.out.println("What is your name? \n >");
                    userName = scanner.nextLine();
                    System.out.println("Pick-up or delivery? \n >");
                    choice = scanner.nextLine();
                    isPickUp = choice.equals("pick-up");
                    coffeeService.addOrder(coffeeService.getCoffee("Expresso"),60,userName,isPickUp);
                    ingredientService.decreaseAmountByName("Expresso", 1);
                    price += coffeeService.getPriceByName("Expresso");
                    checkIngredients();
                    System.out.println("The beverage is Expresso and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 2:
                    System.out.println("What is your name? \n >");
                    userName = scanner.nextLine();
                    System.out.println("Pick-up or delivery? \n >");
                    choice = scanner.nextLine();
                    isPickUp = choice.equals("pick-up");
                    coffeeService.addOrder(coffeeService.getCoffee("Machiatto"),100,userName,isPickUp);
                    ingredientService.decreaseAmountByName("Expresso", 1);
                    ingredientService.decreaseAmountByName("Milk Foam", 1);
                    price += coffeeService.getPriceByName("Machiatto");
                    checkIngredients();
                    System.out.println("The beverage is Machiatto and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 3:
                    System.out.println("What is your name? \n >");
                    userName = scanner.nextLine();
                    System.out.println("Pick-up or delivery? \n >");
                    choice = scanner.nextLine();
                    isPickUp = choice.equals("pick-up");
                    coffeeService.addOrder(coffeeService.getCoffee("Coffee Latte"),100,userName,isPickUp);
                    ingredientService.decreaseAmountByName("Expresso", 1);
                    ingredientService.decreaseAmountByName("Milk Foam", 1);
                    ingredientService.decreaseAmountByName("Steamed Milk", 2);
                    price += coffeeService.getPriceByName("Coffee Latte");
                    checkIngredients();
                    System.out.println("The beverage is Coffee Latte and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 4:
                    System.out.println("What is your name? \n >");
                    userName = scanner.nextLine();
                    System.out.println("Pick-up or delivery? \n >");
                    choice = scanner.nextLine();
                    isPickUp = choice.equals("pick-up");
                    coffeeService.addOrder(coffeeService.getCoffee("Cappucino"),200,userName,isPickUp);
                    ingredientService.decreaseAmountByName("Expresso", 1);
                    ingredientService.decreaseAmountByName("Milk Foam", 2);
                    ingredientService.decreaseAmountByName("Steamed Milk", 1);
                    price += coffeeService.getPriceByName("Cappucino");
                    checkIngredients();
                    System.out.println("The beverage is Cappucino and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 5:
                    System.out.println("What is your name? \n >");
                    userName = scanner.nextLine();
                    System.out.println("Pick-up or delivery? \n >");
                    choice = scanner.nextLine();
                    isPickUp = choice.equals("pick-up");
                    coffeeService.addOrder(coffeeService.getCoffee("Coffee Miel"),250,userName,isPickUp);
                    ingredientService.decreaseAmountByName("Black Coffee",2);
                    ingredientService.decreaseAmountByName("Honey",1);
                    ingredientService.decreaseAmountByName("Cinnamon",1);
                    ingredientService.decreaseAmountByName("Steamed Milk",1);
                    price += coffeeService.getPriceByName("Coffee Miel");
                    checkIngredients();
                    System.out.println("The beverage is Coffee Miel and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 6:
                    System.out.println("Pick-up or delivery? \n >");
                    String clientChoice = scanner.nextLine();
                    boolean pickUp = clientChoice.equals("pick-up");
                    Coffee coffee = makeCustomerCoffee();
                    price += coffee.getPrice();
                    int quantity = (int) coffee.getIngredients().stream().mapToDouble(Ingredient::getAmount).sum();
                    coffeeService.addOrder(coffee,quantity,coffee.getName(),pickUp);
                    System.out.println("Your beverage is named "+ coffee.getName()+" and the coffee shop profit is equal with "+price+" \n >");
                    break;
                case 7:
                    System.out.println("Pick-up or delivery? \n >");
                    String clientPickUpOrNot = scanner.nextLine();
                    boolean pickUpAction = clientPickUpOrNot.equals("pick-up");
                    Coffee clientCoffee = brewingClientCoffee();
                    price += clientCoffee.getPrice();
                    int coffeeQuantity = (int) clientCoffee.getIngredients().stream().mapToDouble(Ingredient::getAmount).sum();
                    coffeeService.addOrderBrewing(clientCoffee,coffeeQuantity,clientCoffee.getName(),pickUpAction);
                    System.out.println("Your beverage is " + clientCoffee.toString());
                    break;
                case 8:
                    if(ingredientService.checkStocksOfIngredients())
                    {
                        System.out.println("The stocks are just fine");
                    }
                    else
                    {
                        checkIngredients();
                    }
                    break;
                case 9:
                    List<Recipe> recipeList = coffeeService.getAllRecipes();

                    for(Recipe recipe: recipeList) {
                        System.out.println(recipe.toString());
                    }
                    break;
            }
        }
    }
}
