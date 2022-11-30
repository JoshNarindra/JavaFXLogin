package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label Text;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    protected void onSignInButtonClick() {
        String name = username.getText();
        String pass = password.getText();

        Text.setText(name + "  " + pass);

        String usernameMaster = "user";
        String passwordMaster = "password";

        if (usernameMaster.equals(name) && passwordMaster.equals(pass)) {
            Text.setText("Login Successful");
        }




    }
}