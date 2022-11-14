package com.example.rupizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onCurrentOrderButtonClick() {
        welcomeText.setText("Open Current Order Window!");
    }

    @FXML
    protected void onStoreOrderButtonClick() {
        welcomeText.setText("Welcome to Store OrderApplication!");
    }

    @FXML
    protected void chicagoButtonClick() {
        welcomeText.setText("Open Current Order Window!");
    }

    @FXML
    protected void newyorkButtonClick() {
        welcomeText.setText("Open Current Order Window!");
    }
}