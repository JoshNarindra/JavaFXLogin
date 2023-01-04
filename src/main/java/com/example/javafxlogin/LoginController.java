package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoginController {
    public Label login;
    public Button sign_in;
    public Button exit;
    public Button reset;

    @FXML
    public static Label Text; //change back to private no static - only for testing sql connection
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    //Functionality for close window button.
    @FXML
    public void onExitButtonClick() {
        Platform.exit();
    }

    //Allows user to reset the text input fields for username and password.
    @FXML
    public void onResetButtonClick() {
        textEmpty();
    }

    //Method to clear text input fields.
    public void textEmpty() {
        username.setText("");
        password.setText("");
        sign_in.setDisable(false);
    }

    @FXML
    protected void onSignInButtonClick() throws SQLException {
        //Evaluates input fields for login. Username and Password checked, correct/incorrect login message displayed.
//        String usernames = "user";
//        String passwords = "password";

//        if (usernames.equals(username.getText()) && passwords.equals(password.getText())) {
//            //Text.setText("Login Successful.");
//            Alert b;
//            b = new Alert(Alert.AlertType.INFORMATION, "Access Granted!", ButtonType.OK);
//            b.showAndWait();
//            textEmpty();
//        } else {
//            //Text.setText("Username or Password incorrect.");
//            Alert a;
//            a = new Alert(Alert.AlertType.ERROR, "Username or Password not recognised!", ButtonType.OK);
//            a.showAndWait();
//            textEmpty();
//        }

        if (!username.getText().isBlank() && !password.getText().isBlank()) {
                validateLogin();
        }
        else {
            Alert b;
            b = new Alert(Alert.AlertType.INFORMATION, "Empty Fields, Please enter username and password!", ButtonType.OK);
            b.showAndWait();
            textEmpty();
        }
    }

    //Stops login button being used if text field is empty.
    public void activateLoginButton() {
        sign_in.setDisable((username.getText().isEmpty() || password.getText().isEmpty()));
    }

    public void validateLogin() throws SQLException {
        DatabaseConnection x = new DatabaseConnection();

        String query = "select COUNT(1) from UserDetails where username=" + "'" + username.getText() + "'" + "and userpassword = '" + password.getText() + "'";

        try {
            var stmt = x.getConnection().prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    Text.setText("Login Successful");
                } else {
                    Text.setText("Login Successful");
                }
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}