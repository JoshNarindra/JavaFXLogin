/*
Class functions as controller for logged in scene.
 */

package com.example.javafxlogin;

//Imports
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoggedInController {
    //Declare variables.
    @FXML
    private Hyperlink ReturnToLogin;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    //Event Method allows user to switch to log in scene when hyperlink clicked.
    @FXML
    public void returnToLogin(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) (ReturnToLogin.getScene().getWindow());
        scene = new Scene(root, 450, 400);
        stage.setScene(scene);
        stage.show();
    }


}
