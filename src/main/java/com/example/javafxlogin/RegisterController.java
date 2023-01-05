package com.example.javafxlogin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

public class RegisterController
{
    //@FXML
    //public void initialize() {
    //}

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
                    System.out.println("Username Already Exists, Please Try Again");
                    textEmpty();
                } else {
                    System.out.println("Username Does Not Exist, user added to database");
                    addUserToDatabase();
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
}