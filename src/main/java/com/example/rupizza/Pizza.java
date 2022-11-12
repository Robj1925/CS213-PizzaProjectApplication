package com.example.rupizza;
import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    public boolean addTopping(Topping t) {
        toppings = new ArrayList<>();
        this.toppings.add(t);
        return false;
    }

    public abstract double price();

    protected ArrayList<Topping> getToppings(){
        return toppings;
    }
}