package com.example.rupizza;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewYorkController implements Initializable {

    @FXML
    public Button addButton;
    @FXML
    public Button removeButton;

    @FXML
    private Label priceLabel;
    @FXML
    private Label crustLabel;

    @FXML
    private ChoiceBox flavorBox;
    @FXML
    private ChoiceBox pizzaSize;

    private Pizza pizza;
    private String currentSize = "medium";
    private PizzaFactory pizzaFactory = new NYPizza();
    private ObservableList<Topping> availableToppings = FXCollections.observableArrayList(Topping.CHEDDAR,Topping.BEEF,Topping.BBQCHICKEN,Topping.GREENPEPPER,Topping.HAM,Topping.MUSHROOM,Topping.ONION,Topping.PEPPERONI,Topping.PROVOLONE,Topping.SAUSAGE,Topping.BLACKOLIVES,Topping.SPINACH,Topping.PINEAPPLE);
    private ObservableList<Topping> deluxeToppings = FXCollections.observableArrayList(Topping.GREENPEPPER,Topping.MUSHROOM,Topping.ONION,Topping.PEPPERONI,Topping.SAUSAGE);
    private ObservableList<Topping> meatzzaToppings = FXCollections.observableArrayList(Topping.BEEF,Topping.HAM,Topping.PEPPERONI,Topping.SAUSAGE);
    private ObservableList<Topping> bbqChickenToppings = FXCollections.observableArrayList(Topping.BBQCHICKEN,Topping.PROVOLONE,Topping.CHEDDAR,Topping.GREENPEPPER);
    private ObservableList<Topping> noToppings = FXCollections.observableArrayList();

    @FXML
    private ListView<Topping> availToppingsLst;
    @FXML
    private ListView<Topping> selectedToppingsView;

    private Order order = new Order();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> flavors = FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build Your Own"); // this the flavors that goes in the combobox gui
        flavorBox.setItems(flavors);

        ObservableList<String> sizes = FXCollections.observableArrayList("small","medium","large");
        pizzaSize.setItems(sizes);

        pizzaSize.getSelectionModel().selectFirst();
        currentSize = "small";

        //   HelloApplication.setCurrOrder(order1);
        order = HelloApplication.getCurrOrder();

    }

    @FXML
    public void selectFlavor() {
        String flavor = flavorBox.getSelectionModel().getSelectedItem().toString();
        if (flavor.equals("Deluxe")) {
            pizza = pizzaFactory.createDeluxe();
            availToppingsLst.getItems().setAll(noToppings);
            selectedToppingsView.getItems().setAll(deluxeToppings);
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (flavor.equals("Meatzza")) {
            availToppingsLst.getItems().setAll(noToppings);
            selectedToppingsView.getItems().setAll(meatzzaToppings);
            pizza = pizzaFactory.createMeatzza();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (flavor.equals("Build Your Own")) {
            pizza = pizzaFactory.createBuildYourOwn();
            pizza.setCurrentSize(currentSize);
            selectedToppingsView.getItems().setAll(noToppings);
            availToppingsLst.getItems().addAll(availableToppings);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (flavor.equals("BBQ Chicken")) {
            availToppingsLst.getItems().setAll(noToppings);
            selectedToppingsView.getItems().setAll(bbqChickenToppings);
            pizza = pizzaFactory.createBBQChicken();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        }
    }

    @FXML
    public void selectSize() {
        currentSize = pizzaSize.getSelectionModel().getSelectedItem().toString(); //gets pizza size selected
        pizza.setCurrentSize(currentSize);
        priceLabel.setText("Price: " + pizza.price());
    }

    @FXML
    public void addTopping() {
        String pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString();
        Topping toppingSelected = availToppingsLst.getSelectionModel().getSelectedItem();
        if (pizzaSelected.equals("Build Your Own") && selectedToppingsView.getItems().size() < 7 && toppingSelected != null) {
            pizza.add(toppingSelected);
            priceLabel.setText("Price: " + pizza.price());
            availToppingsLst.getItems().remove(toppingSelected);
            selectedToppingsView.getItems().add(toppingSelected);

        } else if (selectedToppingsView.getItems().size() == 7) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Maximum number of toppings reached!");
            alert.setContentText("Only 7 toppings allowed!");
            alert.showAndWait();
        }
    }

    @FXML
    public void removeTopping() {
        String pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString();
        Topping toppingSelected = selectedToppingsView.getSelectionModel().getSelectedItem();
        if (pizzaSelected.equals("Build Your Own") && toppingSelected != null) {
            pizza.remove(toppingSelected);
            availToppingsLst.getItems().add(toppingSelected);
            selectedToppingsView.getItems().remove(toppingSelected);
            priceLabel.setText("Price: " + pizza.price());
        }
    }

    @FXML
    public void addPizzaToOrder() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pizza Added!");
        alert.setContentText("Pizza has been added to cart!");
        alert.showAndWait();
        order.add(pizza);
        HelloApplication.getCurrOrder();
        priceLabel.setText("Total: " + String.valueOf(pizza.price()) + " :" + HelloApplication.getCurrOrder().getSize());
    }

    public String getCurrPrice() {
        return priceLabel.getText();
    }
}
