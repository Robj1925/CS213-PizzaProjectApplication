package com.example.rupizza;

import com.example.rupizza.interfaces.Customizable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Random;
import java.text.DecimalFormat;

public class Order implements Customizable {
    private double total;
    private int orderNumber; // serial number/order #
    private Random rd = new Random();
  //  private double total;
  //  private int numOfPizzas = 0;


    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
           this.total = 0.0;
        DecimalFormat df = new DecimalFormat("0.00");
        for (Pizza p : getPizzas()) {
            total += p.price();
        }

        return Double.parseDouble(df.format(total));
    }

    private ObservableList<Pizza> pizzas; // keeps track of all the pizzas in an order



    public Order() {
        this.orderNumber = Math.abs(rd.nextInt()); // assigns rand int to order num
        pizzas = FXCollections.observableArrayList(); //init pizzas list
        total = 0.0;

    }

    @Override
    public String toString() {
        return
                " " + orderNumber ;
    }

    @Override
    public boolean add(Object obj) {
        // total = total + ((Pizza) obj).price();
        return getPizzas().add((Pizza)obj);
    }

    @Override
    public boolean remove(Object obj) {
       // total -= ((Pizza) obj).price();
        return getPizzas().remove((Pizza)obj);
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public int getSize() {
        return pizzas.size();
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ObservableList<Pizza> getPizzas() {
        return pizzas;
    }
}
