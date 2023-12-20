package com.example.rupizza.Controllers;

import com.example.rupizza.HelloApplication;
import com.example.rupizza.Order;
import com.example.rupizza.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import com.example.rupizza.Utilities.mySQLConnectionUtility;


import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {
    @FXML
    private Label total;

    @FXML
    private ComboBox orderNumber;

    private Order orderSelected;
    @FXML
    private ListView<Pizza> currOrderSelectedPizzas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Order> allOrders = FXCollections.observableArrayList();
  //BEfore
//        allOrders.setAll(HelloApplication.getAllOrders());
//        orderNumber.setItems(HelloApplication.getAllOrders());
//        orderNumber.setItems(allOrders);
// AFTER
        try {
          //  allOrders.setAll(mySQLConnectionUtility.getOrders());
            orderNumber.setItems((ObservableList) mySQLConnectionUtility.getOrders());
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void orderChosen(ActionEvent actionEvent) {

//        BEFORE:
//        orderSelected = (Order)orderNumber.getSelectionModel().getSelectedItem();
//        System.out.println(orderSelected);
//        if (orderSelected != null) {
//            currOrderSelectedPizzas.setItems(orderSelected.getPizzas());
//            total.setText("Order Total: $" + orderSelected.getTotal());
//        } else {
//            currOrderSelectedPizzas.setItems(null);
//        }
//        AFTER:
        orderSelected = (Order) orderNumber.getSelectionModel().getSelectedItem();
        total.setText("Order Total: $" + orderSelected.getTotal());

    }

    @FXML
    public void cancelButtonClick(ActionEvent actionEvent) {
        if (orderSelected != null && currOrderSelectedPizzas.getItems().size() > 0) {
            total.setText("Order Total: $0.00");
            currOrderSelectedPizzas.getItems().remove(orderSelected);
            HelloApplication.getAllOrders().remove(orderSelected);
            System.out.println(currOrderSelectedPizzas.getItems());
        }


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Order Removed!");
        alert.setContentText("Order has been removed from current orders! Please refresh window!");
        alert.showAndWait();
        //TODO: Delete Orders From Database
        orderNumber.setItems(HelloApplication.getAllOrders());


    }
}