package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private DecimalFormat df = new DecimalFormat("0.00");


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
        Order newOrder = new Order();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        pizzaListView.getItems().removeAll(HelloApplication.getCurrOrder().getPizzas());

        HelloApplication.setCurrOrder(newOrder);
        orNumTxtF.setText("Order Number: " + String.valueOf(HelloApplication.getCurrOrder().getOrderNumber()));
        subTotalTextF.setText("Subtotal: " + String.valueOf(HelloApplication.getCurrOrder().getTotal()));
        salesTaxField.setText("Sales Tax: " + df.format(HelloApplication.getCurrOrder().getTotal() *  .06625));
        totalTextF.setText("Total : " + df.format(HelloApplication.getCurrOrder().getTotal() *  .06625 + HelloApplication.getCurrOrder().getTotal()));

        alert.setTitle("Order Cleared!");
        alert.setContentText("All pizzas have been removed from order");
        alert.showAndWait();

    }

    @FXML
    void placeOrder(ActionEvent event) {
        //move to currentOrder to StoreOrders class
        HelloApplication.addOrderToStore(HelloApplication.getCurrOrder());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        pizzaListView.getItems().removeAll(HelloApplication.getCurrOrder().getPizzas());
        Order newOrder = new Order();
        HelloApplication.setCurrOrder(newOrder);

        orNumTxtF.setText("Order Number: " + String.valueOf(HelloApplication.getCurrOrder().getOrderNumber()));
        subTotalTextF.setText("Subtotal: " + String.valueOf(HelloApplication.getCurrOrder().getTotal()));
        salesTaxField.setText("Sales Tax: " + df.format(HelloApplication.getCurrOrder().getTotal() *  .06625));
        totalTextF.setText("Total : " + df.format(HelloApplication.getCurrOrder().getTotal() *  .06625 + HelloApplication.getCurrOrder().getTotal()));

        alert.setTitle("Order placed!");
        alert.setContentText("Order has been placed.");
        alert.showAndWait();

    }

    @FXML
    void removePizza(ActionEvent event) {
        Pizza pizzaSelected = pizzaListView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         if (HelloApplication.getCurrOrder().remove(pizzaSelected) == true && pizzaListView.getItems().remove(pizzaSelected) == true) {
             alert.setTitle("Pizza Removed!");
             alert.setContentText("Pizza has been removed from cart!");
             alert.showAndWait();
             subTotalTextF.setText("Subtotal: " + String.valueOf(HelloApplication.getCurrOrder().getTotal()));
             salesTaxField.setText("Sales Tax: " + df.format(HelloApplication.getCurrOrder().getTotal() *  .06625));
             totalTextF.setText("Total : " + df.format((HelloApplication.getCurrOrder().getTotal() *  .06625) + HelloApplication.getCurrOrder().getTotal()));
         } else {
             alert.setTitle("Pizza not removed!");
             alert.setContentText("Pizza not removed, try again.");
             alert.showAndWait();
         }
        //update subtotal , total / sales tax
    }

}
