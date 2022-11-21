package com.example.rupizza;

public class BBQChicken extends Pizza{

    public BBQChicken() {
        super.init();
        add(Topping.BBQCHICKEN);
        add(Topping.GREENPEPPER);
        add(Topping.PROVOLONE);
        add(Topping.CHEDDAR);
        super.printToppings();
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
            price = 13.99;
        } else if (getCurrentSize().equals("medium")) {
            price = 15.99;
        } else if (getCurrentSize().equals("large")) {
            price = 17.99;
        }
        return price;
    }
}

