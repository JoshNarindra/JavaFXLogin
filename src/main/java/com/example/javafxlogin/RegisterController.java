package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

public class RegisterController
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