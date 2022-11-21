package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order implements Customizable{
    private int orderNumber; // serial number/order #
    private double total;
  //  private int numOfPizzas = 0;


    public double getTotal() {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(total));
    }

    private ObservableList<Pizza> pizzas; // keeps track of all the pizzas in an order



    public Order() {
        this.orderNumber = (int) (Math.random() * Long.MAX_VALUE); // assigns rand int to order num
        pizzas = FXCollections.observableArrayList(); //init pizzas list
    }

    @Override
    public String toString() {
        return "This is a test" +
                "orderNumber=" + orderNumber +
                ", pizzas=" + pizzas +
                '}';
    }

    @Override
    public boolean add(Object obj) {
        total = total + ((Pizza) obj).price();
        return getPizzas().add((Pizza)obj);
    }

    @Override
    public boolean remove(Object obj) {
        total -= ((Pizza) obj).price();
        return getPizzas().remove((Pizza)obj);
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public int getSize() {
        return pizzas.size();
    }
    public ObservableList<Pizza> getPizzas() {
        return pizzas;
    }
}
