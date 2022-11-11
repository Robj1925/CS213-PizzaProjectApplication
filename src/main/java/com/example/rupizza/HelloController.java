package com.example.rupizza;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
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
}