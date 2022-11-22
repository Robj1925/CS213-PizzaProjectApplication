package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {

    private Store store;
    @FXML
    private ComboBox orderNumber;
    @FXML
    private Label priceLabel;
    private Order orderSelected;
    @FXML
    private ListView<Pizza> allStoreOrders;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        int numOfOrders = store.orders.size();
        ObservableList<Order> allOrders = FXCollections.observableArrayList();
        allOrders.setAll(HelloApplication.getAllOrders());
        orderNumber.setItems(HelloApplication.getAllOrders());
      //  orderNumber.getSelectionModel().selectFirst();
      //  priceLabel.setText("Order Total: " + HelloApplication.getStoreObj().getTotal());
      //  orderSelected = orderNumber.getSelectionModel();

      //  for (int i = 1; i <= numOfOrders; i++) { allOrders.add(i+""); }

        orderNumber.setItems(allOrders);


    }

    @FXML
    public void orderChosen(ActionEvent actionEvent) {
        orderSelected = (Order)orderNumber.getSelectionModel().getSelectedItem();
        allStoreOrders.setItems(orderSelected.getPizzas());

    }

    @FXML
    public void cancelButtonClick(ActionEvent actionEvent) {
        store.getOrders().removeAll();
    }
}