package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DecimalFormat;

public class Store implements Customizable {


   private ObservableList<Order> orders;

    public Store() {
        this.orders = FXCollections.observableArrayList();
    }

    @Override
    public boolean add(Object obj) {
        return getOrders().add((Order) obj);
    }

    @Override
    public boolean remove(Object obj) {
        return getOrders().remove((Order)obj);
    }

    public ObservableList<Order> getOrders() {
        return orders;
    }
    public double getTotal() {
        double total = 0.0;
        DecimalFormat df = new DecimalFormat("0.00");
        if (getSize() == 0) {
            return Double.parseDouble(df.format(total));
        }
        for (Order p : getOrders()) {
            total += p.getTotal();
        }

        return Double.parseDouble(df.format(total));
    }
    public int getSize() {
        return getOrders().size();
    }
}