package com.example.rupizza;

import com.example.rupizza.interfaces.PizzaFactory;

public class ChicagoPizza implements PizzaFactory {

    @Override
    public Pizza createDeluxe() { //creates Chicago Style Deluxe flavor with preset toppings and Crust
        Pizza pizza = new Deluxe(); // creates deluxe object
        pizza.setCrust("deepdish"); //sets crust to deepdish
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust("stuffed");
        return pizza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust("pan");
        return pizza;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust("pan");
        return pizza;
    }
}

