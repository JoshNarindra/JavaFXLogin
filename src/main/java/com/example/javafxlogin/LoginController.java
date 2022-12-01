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

//      Functionality for one username-input combo - NOT CASE SENSITIVE.
        String usernames = "user";
        String passwords = "password";

        if (usernames.equals(username.getText()) && passwords.equals(password.getText())) {
            Text.setText("Login Successful.");
        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
            Text.setText("At least one field is empty please try again.");
        } else {
            Text.setText("Username or Password incorrect.");
        }

//        //Hashmap to store username-password combinations
//        HashMap<String, String> loginPair = new HashMap<String, String>();
//
//        loginPair.put("user","password");
//        loginPair.put("user1","password1");
//        loginPair.put("user2","password2");
//
//        boolean check = false;
//
//        for (String i : loginPair.keySet()) {
//            if (i.equals(username.getText()) && loginPair.get(i).equals(password.getText())){
//                Text.setText("Login Successful.");
//            }
//            else {
//                Text.setText("Login Unsuccessful.");
//            }
//        }
    }


    @FXML
    public void onExitButtonClick() {
            Platform.exit();
    }

    @FXML
    public void onResetButtonClick(){
        textEmpty();
    }

    public void textEmpty(){
        username.setText("");
        password.setText("");
    }

}