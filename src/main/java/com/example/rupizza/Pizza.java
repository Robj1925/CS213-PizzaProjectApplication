package com.example.rupizza;
import java.util.ArrayList;

public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;


    public int getSize() { //gets size of toppings arraylist (for testing purposes)
        return toppings.size();
    }
    public void init() { //init arraylist, crust, and size object
        this.toppings = new ArrayList<>();
        crust = new Crust();
        size = new Size();
    }
    public void setCrust(String c) {
        this.crust.setCrust(c);
    }
    public String getCrust() {
      return this.crust.getCrust();
    }
    public String getStyle() {
        if (getCrust().equals("pan") || getCrust().equals("deepdish" )|| getCrust().equals("stuffed")) {
            return "Chicago Style";
        } else return "NY Style";
    }
    public String getCurrentSize() { //gets size of pizza
        return size.getCurrentSize();
    }
    public void setCurrentSize(String s) {
        this.size.setCurrentSize(s);
    }
    public String printToppings() {
        String toppings = "";
        for (Topping t : getToppings()) {
            toppings = t + " " + toppings;
        }
        return toppings;
    }
    public abstract double price();

    protected ArrayList<Topping> getToppings(){
        return toppings;
    }


}