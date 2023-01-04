module com.example.javafxlogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxlogin to javafx.fxml;
    exports com.example.javafxlogin;
}