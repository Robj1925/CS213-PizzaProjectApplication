package com.example.rupizza;

public class ChicagoPizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() { //creates Chicago Style Deluxe flavor with preset toppings and Crust
        Pizza pizza = new Deluxe(); // creates deluxe object
        pizza.setCrust("deepdish"); //sets crust to deepdish
      //  pizza.setCurrentSize("small");
        return pizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust("stuffed");
       // pizza.setCurrentSize("large");
        return pizza;
    }

    @Override
    public Pizza createBBQChicken() {
        return null;
    }

    @Override
    public Pizza createBuildYourOwn() {
        return null;
    }
}

