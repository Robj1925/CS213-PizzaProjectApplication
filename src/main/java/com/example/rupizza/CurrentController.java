package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CurrentController implements Initializable {
    @FXML
    private ListView<Pizza> pizzaListView ;
    @FXML
    private Text salesTaxField;
    @FXML
    private Button clearOrder;

    @FXML
    private Text orNumTxtF;

    @FXML
    private Button placeOrder;

    @FXML
    private Button removePizza;

    @FXML
    private Text subTotalTextF;

    @FXML
    private Text totalTextF;
    private double salesTax = HelloApplication.getCurrOrder().getTotal() *  .06625;
    private DecimalFormat df = new DecimalFormat("#.00");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orNumTxtF.setText("Order Number: " + String.valueOf(HelloApplication.getCurrOrder().getOrderNumber()));
        subTotalTextF.setText("Subtotal: " + String.valueOf(HelloApplication.getCurrOrder().getTotal()));
        salesTaxField.setText("Sales Tax: " + df.format(salesTax));
        totalTextF.setText("Total : " + df.format(salesTax + HelloApplication.getCurrOrder().getTotal()));

        pizzaListView.getItems().addAll(HelloApplication.getCurrOrder().getPizzas());
    }

    @FXML
    void clearOrder(ActionEvent event) {
        //make alert

    }

    @FXML
    void placeOrder(ActionEvent event) {
        //move to currentOrder to StoreOrders class
        Order newOrder = new Order();
        HelloApplication.setCurrOrder(newOrder);
    }

    @FXML
    void removePizza(ActionEvent event) {
        Pizza pizzaSelected = pizzaListView.getSelectionModel().getSelectedItem();
        pizzaListView.getItems().remove(pizzaSelected);
        HelloApplication.getCurrOrder().remove(pizzaSelected);
        //update subtotal , total / sales tax
    }

}
