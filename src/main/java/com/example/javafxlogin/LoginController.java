package com.example.javafxlogin;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Platform;
//import java.util.HashMap;
//import javafx.event.ActionEvent;

public class LoginController {
    public Label login;
    public Button sign_in;

    public Button exit;

    public Button reset;
    @FXML
    private Label Text;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    protected void onSignInButtonClick() {

    //Evaluates input fields for login. Username and Password checked, correct/incorrect login message displayed.
        String usernames = "user";
        String passwords = "password";

        if (usernames.equals(username.getText()) && passwords.equals(password.getText())) {
            Text.setText("Login Successful.");
        } else {
            Text.setText("Username or Password incorrect.");
        }
    }

    //Functionality for close window button.
    @FXML
    public void onExitButtonClick() {
            Platform.exit();
    }

    //Allows user to reset the text input fields for username and password.
    @FXML
    public void onResetButtonClick(){
        textEmpty();
    }

    //Method to clear text input fields.
    public void textEmpty(){
        username.setText("");
        password.setText("");
        sign_in.setDisable(false);
    }

    //Stops login button being used if text field is empty.
    public void activateLoginButton(){
        sign_in.setDisable((username.getText().isEmpty() || password.getText().isEmpty()));
    }

}