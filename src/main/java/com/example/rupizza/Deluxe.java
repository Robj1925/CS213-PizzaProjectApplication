package com.example.rupizza;

public class Deluxe extends Pizza{
    public Deluxe() {
        super.init();
        add(Topping.SAUSAGE);
        add(Topping.GREENPEPPER);
        add(Topping.ONION);
        add(Topping.PEPPERONI);
        add(Topping.MUSHROOM);

        // System.out.println(super.getSize());
       // super.printToppings();

    }
    @Override
    public boolean add(Object obj) {
       return super.getToppings().add((Topping) obj);
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public double price() {
        double price = 0;
        if(getCurrentSize().equals("small")){
            price = 14.99;
        } else if (getCurrentSize().equals("medium")) {
            price = 16.99;
        } else if (getCurrentSize().equals("large")) {
            price = 18.99;
        }
        return price;
    }
    @Override
    public String toString() {
        return "Deluxe " +
                "(" + getStyle() +
                " - " + getCrust() +
                ") " +
                "toppings = " + getToppings() +
                " $" + price() +
                '}';
    }

}
