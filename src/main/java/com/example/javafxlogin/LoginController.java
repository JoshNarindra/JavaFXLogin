package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.HashMap;

public class LoginController {
    public Label login;
    public Button sign_in;
    @FXML
    private Label Text;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    protected void onSignInButtonClick() {

        String usernames = "user";
        String passwords = "password";

        if (usernames.equals(username.getText()) && passwords.equals(password.getText())) {
            Text.setText("Login Successful.");
        }
        else if (username.getText().isEmpty() || password.getText().isEmpty()){
            Text.setText("At least one field is empty please try again.");
        }
        else {
            Text.setText("Username or Password incorrect.");
        }
    }
}