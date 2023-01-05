package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.application.Platform;

import java.io.IOException;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LoggedInController {
    @FXML
    private Hyperlink ReturnToLogin;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    public void returnToLogin(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)(ReturnToLogin.getScene().getWindow());
        scene = new Scene(root, 450, 400);
        stage.setScene(scene);
        stage.show();
    }


}
