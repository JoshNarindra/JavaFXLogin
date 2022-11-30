package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onSignInButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}