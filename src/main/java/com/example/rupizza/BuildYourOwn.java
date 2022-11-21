package com.example.rupizza;

import java.text.DecimalFormat;

public class BuildYourOwn extends Pizza{

    public BuildYourOwn() {
        super.init();
    }

    @Override
    public boolean add(Object obj) {
        return super.getToppings().add((Topping) obj);
    }

    @Override
    public boolean remove(Object obj) {
        return super.getToppings().remove((Topping) obj);
    }

    @Override
    public double price() {
        double price = 0;
        if(getCurrentSize().equals("small")){
            price = 8.99;
        } else if (getCurrentSize().equals("medium")) {
            price = 10.99;
        } else if (getCurrentSize().equals("large")) {
            price = 12.99;
        }
        double toppingsPrice = super.getSize() * 1.59;
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(price + toppingsPrice));
    }
    @Override
    public String toString() {
        return "BuildYourOwn " +
                "(" + getStyle() +
                " - " + getCrust() +
                ") " +
                "toppings = " + getToppings() +
                '}';
    }
}
