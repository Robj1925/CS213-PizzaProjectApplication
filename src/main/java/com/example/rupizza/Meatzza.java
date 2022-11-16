package com.example.rupizza;

public class Meatzza extends Pizza{
    public Meatzza() {
        super.init();
        add(Topping.SAUSAGE);
        add(Topping.PEPPERONI);
        add(Topping.BEEF);
        add(Topping.HAM);

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
            price = 15.99;
        } else if (getCurrentSize().equals("medium")) {
            price = 17.99;
        } else if (getCurrentSize().equals("large")) {
            price = 19.99;
        }
        return price;
    }
}
