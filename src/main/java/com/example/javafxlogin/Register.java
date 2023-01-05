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

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Register
{
    @FXML
    public void initialize() {
    }

    @FXML
    public TextField usernametextfield;

    @FXML
    public TextField passwordtextfield;

    public void registerButtonClick(ActionEvent actionEvent) {
        if (!usernametextfield.getText().isBlank() && !passwordtextfield.getText().isBlank()) {
            registerUser();
        }
        else {
            Alert b;
            b = new Alert(Alert.AlertType.INFORMATION, "Empty Fields, Please enter username and password!", ButtonType.OK);
            b.showAndWait();
            textEmpty();
        }
    }

    private void registerUser() {
        DatabaseConnection x = new DatabaseConnection();

        String query = "insert into UserDetails(username,userpassword) values ('" + usernametextfield.getText() + "'" + ", '" + passwordtextfield.getText() + "');";

    }

    public void textEmpty() {
        usernametextfield.setText("");
        passwordtextfield.setText("");
    }
}