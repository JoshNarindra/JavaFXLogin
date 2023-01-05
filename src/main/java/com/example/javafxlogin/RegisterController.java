package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController
{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
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

        String query = "select COUNT(1) from UserDetails where username= '" + usernametextfield.getText() + "'";

        try {

            var stmt = x.getConnection().prepareStatement(query);
            var rs = stmt.executeQuery();

            while (rs.next()) {
                //if statement checks if username inputted already exists in database. If it does not it registers the user into the system.
                if (rs.getInt(1) == 1) {
                    Alert b;
                    b = new Alert(Alert.AlertType.INFORMATION, "Username Already Exists, Please Try Again", ButtonType.OK);
                    b.showAndWait();

                    textEmpty();
                } else {
                    Alert b;
                    b = new Alert(Alert.AlertType.INFORMATION, "User Registered", ButtonType.OK);
                    b.showAndWait();

                    textEmpty();
                    addUserToDatabase();
                    returnToLogin();
                }
            }

        }
        catch(Exception e ){
            e.printStackTrace();
        }


    }

    private void addUserToDatabase() {
        DatabaseConnection x = new DatabaseConnection();

        String query = "insert into UserDetails(username,userpassword) values ('" + usernametextfield.getText() + "'" + ", '" + passwordtextfield.getText() + "');";
        try {

            var stmt = x.getConnection().prepareStatement(query);
            stmt.executeUpdate();
        }
        catch(Exception e ){
            e.printStackTrace();
        }
    }

    public void textEmpty() {
        usernametextfield.setText("");
        passwordtextfield.setText("");
    }

    @FXML
    public void returnToLogin() throws IOException {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)(usernametextfield.getScene().getWindow());
        scene = new Scene(root, 450, 400);
        stage.setScene(scene);
        stage.show();
    }
}