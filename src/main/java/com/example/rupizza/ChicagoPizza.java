package com.example.rupizza;

public class ChicagoPizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();

        return null;
    }

    @Override
    public Pizza createMeatzza() {
        return null;
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

