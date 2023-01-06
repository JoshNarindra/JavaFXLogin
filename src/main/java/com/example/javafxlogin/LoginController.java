/*
Class functions as controller for login scene.
 */

package com.example.javafxlogin;

//Imports
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.application.Platform;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class LoginController {
    //Declare FXML variables.
    @FXML
    public Label login;
    @FXML
    public Button sign_in;
    @FXML
    public Button exit;
    @FXML
    public Button reset;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
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

    //Evaluates whether input fields are empty when login is pressed. Alerts user if they are empty - calls validate user method if not.
    @FXML
    protected void onSignInButtonClick() throws SQLException {
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

    //Method to clear text input fields.
    public void textEmpty() {
        username.setText("");
        password.setText("");
        sign_in.setDisable(false);
    }

    //Stops login button being used if text field is empty.
    public void activateLoginButton() {
        sign_in.setDisable((username.getText().isEmpty() || password.getText().isEmpty()));
    }

    //Runs SQL query to validate username/password exist in UserDetails database.
    //If found calls a method to switch scene to logged in screen. If not notifies user.
    public void validateLogin() throws SQLException {
        DatabaseConnection x = new DatabaseConnection();
        String query = "select COUNT(1) from UserDetails where username=" + "'" + username.getText() + "'" + "and userpassword = '" + password.getText() + "'";

        try {
            var stmt = x.getConnection().prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    System.out.println("Login Successful");
                    switchToLoggedIn();
                } else {
                    Alert b;
                    b = new Alert(Alert.AlertType.INFORMATION, "User does not exist!", ButtonType.OK);
                    b.showAndWait();
                    textEmpty();
                }
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    //Method switches scene to Register User scene, upon clicking hyperlink.
    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Switch to Logged In Scene.
    @FXML
    public void switchToLoggedIn() throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
        stage = (Stage)sign_in.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}