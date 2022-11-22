package com.example.rupizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class NewYorkController implements Initializable {
    @FXML
    public Button addButton;
    @FXML
    public Button removeButton;
    @FXML
    private ListView<Topping> selectedToppingsView;
    @FXML
    private Button addPizza;
    @FXML
    private Label priceLabel;
    private Order order1 = new Order();

    private Pizza pizza;
    private String currentSize = "";
    private PizzaFactory pizzaFactory = new NYPizza();
    private ObservableList<Topping> availableToppings = FXCollections.observableArrayList(Topping.CHEDDAR,Topping.BEEF,Topping.BBQCHICKEN,Topping.GREENPEPPER,Topping.HAM,Topping.MUSHROOM,Topping.ONION,Topping.PEPPERONI,Topping.PROVOLONE,Topping.SAUSAGE,Topping.BLACKOLIVES,Topping.SPINACH,Topping.PINEAPPLE);
    private ObservableList<Topping> deluxeToppings = FXCollections.observableArrayList(Topping.GREENPEPPER,Topping.MUSHROOM,Topping.ONION,Topping.PEPPERONI,Topping.SAUSAGE);
    private ObservableList<Topping> meatzzaToppings = FXCollections.observableArrayList(Topping.BEEF,Topping.HAM,Topping.PEPPERONI,Topping.SAUSAGE);
    private ObservableList<Topping> bbqChickenToppings = FXCollections.observableArrayList(Topping.BBQCHICKEN,Topping.PROVOLONE,Topping.CHEDDAR,Topping.GREENPEPPER);
    private ObservableList<Topping> noToppings = FXCollections.observableArrayList();

    @FXML
    private ListView<Topping> availToppingsLst;
    @FXML
    private ComboBox flavorBox;
    @FXML
    private Label crustLabel;
    @FXML
    private ComboBox pizzaSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> flavors = FXCollections.observableArrayList("Deluxe","BBQ Chicken","Meatzza","Build Your Own"); // this the flavors that goes in the combobox gui
        flavorBox.setItems(flavors);

        ObservableList<String> sizes = FXCollections.observableArrayList("small","medium","large");
        pizzaSize.setItems(sizes);

       pizzaSize.getSelectionModel().selectFirst();
        //flavorBox.getSelectionModel().selectFirst();
         currentSize = "small";
        //pizza = pizzaFactory.createDeluxe();
       // priceLabel.setText("Price: " + pizza.price());

        //   HelloApplication.setCurrOrder(order1);
        order1 = HelloApplication.getCurrOrder();


    }

    public void selectFlavor(ActionEvent actionEvent) {
        String pizzaSelected = "";
        if (flavorBox.getValue() != null) pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString();
        if (pizzaSelected.equals("Deluxe")) { //checks if deluxe is selected
            pizza = pizzaFactory.createDeluxe(); //creats pizza with deluxe toppings
            availToppingsLst.getItems().setAll(noToppings); //makes no toppings availble to be selected
            selectedToppingsView.getItems().setAll(deluxeToppings); // sets selected toppings to deluxe toppings
            pizza.setCurrentSize(currentSize); // updates pizza size to current size selected
            priceLabel.setText("Price: " + pizza.price()); //changes label to pizza price
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (pizzaSelected.equals("Meatzza")) { //checks if meatzza is selected
            availToppingsLst.getItems().setAll(noToppings); //
            selectedToppingsView.getItems().setAll(meatzzaToppings);
            pizza = pizzaFactory.createMeatzza();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (pizzaSelected.equals("Build Your Own")) {
            pizza = pizzaFactory.createBuildYourOwn();
            pizza.setCurrentSize(currentSize);
            selectedToppingsView.getItems().setAll(noToppings);
            availToppingsLst.getItems().addAll(availableToppings);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
        } else if (pizzaSelected.equals("BBQ Chicken")) {
            availToppingsLst.getItems().setAll(noToppings);
            selectedToppingsView.getItems().setAll(bbqChickenToppings);
            pizza = pizzaFactory.createBBQChicken();
            pizza.setCurrentSize(currentSize);
            priceLabel.setText("Price: " + pizza.price());
            crustLabel.setText("Crust: " + pizza.getCrust());
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

        flavorBox.getSelectionModel().clearSelection();

        priceLabel.setText("Total: 0.00" + " :" + HelloApplication.getCurrOrder().getSize());
    }
    public String getCurrPrice() {
        return priceLabel.getText();
    }

    public void addTopping(ActionEvent actionEvent) {
        String pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString(); // gets string of whatever flavor is selected
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

    public void removeTopping(ActionEvent actionEvent) {
        String pizzaSelected = flavorBox.getSelectionModel().getSelectedItem().toString(); // gets string of whatever flavor is selected
        Topping toppingSelected = selectedToppingsView.getSelectionModel().getSelectedItem();
        if (pizzaSelected.equals("Build Your Own") && toppingSelected != null) {
            pizza.remove(toppingSelected);
            availToppingsLst.getItems().add(toppingSelected);
            selectedToppingsView.getItems().remove(toppingSelected);
            priceLabel.setText("Price: " + pizza.price());
        }
    }
}
