package com.example.rupizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;
    private Order currentOrder = new Order();

    @FXML
    protected void onCurrentOrderButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("current-order-view.fxml")); // use this to open up more windows
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // .load() makes it visible
        Stage stage = new Stage();
        stage.setTitle("RU Pizza:Shopping Cart"); //stage is just window
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onStoreOrderButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("current-order-view.fxml")); // use this to open up more windows
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // .load() makes it visible
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // when you open up another window you cant do anything in this window until you close that window
        stage.setTitle("RU Pizza:Shopping Cart"); //stage is just window
        stage.setScene(scene);
        stage.show();    }

    @FXML
    protected void chicagoButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chicago-order-view.fxml")); // use this to open up more windows
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // .load() makes it visible
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL); // when you open up another window you cant do anything in this window until you close that window
        stage.setTitle("RU Pizza:Chicago Style Order"); //stage is just window
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void newyorkButtonClick() {
        welcomeText.setText("Open Current Order Window!");
    }
}