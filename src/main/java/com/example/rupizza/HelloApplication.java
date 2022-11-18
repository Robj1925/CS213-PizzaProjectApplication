package com.example.rupizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Order currOrder = new Order();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml")); // use this to open up more windows
        Scene scene = new Scene(fxmlLoader.load(), 516, 523); // .load() makes it visible
        stage.setTitle("RU Pizza"); //stage is just window
        stage.setScene(scene);
        stage.show();

    }

    public static void setCurrOrder(Order currOrder) {
        HelloApplication.currOrder = currOrder;
    }

    public static Order getCurrOrder() {
        return currOrder;
    }

    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new ChicagoPizza();
        Pizza pizza = pizzaFactory.createDeluxe();
        System.out.println(pizza.getCrust());
        System.out.println(pizza.price());

        Pizza pizza1 = pizzaFactory.createMeatzza();
        System.out.println(pizza1.price());
        System.out.println(pizza.price());

        launch();
    }
}
// tostring method and printwriter for exporting files
//