package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChicagoController implements Initializable {
    @FXML
    private Button addPizza;
    @FXML
    private Label priceLabel;
    private Order order1 = new Order();

    private Pizza pizza;
    private String currentSize = "";
    private PizzaFactory pizzaFactory = new ChicagoPizza();

    @FXML
    private ListView<Topping> pizzaview;
    @FXML
    private ComboBox flavorBox;
    @FXML
    private Label testLabel;
    @FXML
    private ComboBox pizzaSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flavors = FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build Your Own"); // this the flavors that goes in the combobox gui
        flavorBox.setItems(flavors);

        ObservableList<String> sizes = FXCollections.observableArrayList("small","medium","large");
        pizzaSize.setItems(sizes);

        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.CHEDDAR,Topping.BEEF,Topping.BBQCHICKEN,Topping.GREENPEPPER,Topping.HAM,Topping.MUSHROOM,Topping.ONION,Topping.PEPPERONI,Topping.PROVOLONE,Topping.SAUSAGE);
        pizzaview.getItems().addAll(toppings);

        PizzaFactory pizzaFactory = new ChicagoPizza();

     //   HelloApplication.setCurrOrder(order1);
        order1 = HelloApplication.getCurrOrder();


    }

    public void selectFlavor(ActionEvent actionEvent) {
        String pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString(); // gets string of whatever flavor is selected
        if (pizzaSelected.equals("Deluxe")) { //checks if deluxe is selected
            pizza = pizzaFactory.createDeluxe();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());

        } else if (pizzaSelected.equals("Meatzza")) {
            pizza = pizzaFactory.createMeatzza();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
        }
    }

    public void selectSize(ActionEvent actionEvent) {
         currentSize = pizzaSize.getSelectionModel().getSelectedItem().toString(); //gets pizza size selected
        pizza.setCurrentSize(currentSize);
        priceLabel.setText("Price: " + pizza.price());

    }

    public void addPizzaToOrder(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pizza Added!");
        alert.setContentText("Pizza has been added to cart!");
        alert.showAndWait();
        order1.add(pizza);
        HelloApplication.getCurrOrder();
        priceLabel.setText("Total: " + String.valueOf(pizza.price()) + " :" + order1.getSize());
    }
    public static double getCurrPrice() {
        return 0.0;
    }
}
