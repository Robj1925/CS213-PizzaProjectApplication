package com.example.rupizza;

public class Deluxe extends Pizza{
    public Deluxe() {
        super.addTopping(Topping.SAUSAGE);
        for (Topping t:super.getToppings()) {
            System.out.println(t);
        }

    }
    @Override
    public boolean add(Object obj) {
       return super.addTopping((Topping) obj);
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public double price() {
        return 0;
    }
    public void printToppings() {
        for (Topping t:super.getToppings()) {
            System.out.println(t);
        }
    }
}
