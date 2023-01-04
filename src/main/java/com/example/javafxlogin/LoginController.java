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

    @FXML
    protected void onSignInButtonClick() {
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
            try {
                DatabaseConnection x = new DatabaseConnection();

                String query = "select * from UserDetails where username=" + "'" + username.getText() + "'";

                var stmt = x.getConnection().prepareStatement(query);
                var rs = stmt.executeQuery();

                while (rs.next()) {
                    if((rs.getString("userpassword")) == password.getText());
                    System.out.println("Login Successful");
                    }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            Alert b;
            b = new Alert(Alert.AlertType.INFORMATION, "Empty Fields!", ButtonType.OK);
            b.showAndWait();
            textEmpty();
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

    public void onRegisterButtonClick(MouseEvent mouseEvent) {
    }
}