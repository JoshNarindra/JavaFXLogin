/*
Class to create instance of DatabaseConnection object.
 */
package com.example.javafxlogin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static String website = "jdbc:sqlserver://SQL8002.site4now.net;database=db_a8cc79_Josall";
    static String username = "db_a8cc79_Josall_admin";
    static String password = "Mi92uN44oC47";
    public static Connection connection;

    //Method returns variable of type connection, which is SQL connection to server.
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(website, username, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
