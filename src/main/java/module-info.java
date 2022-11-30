module com.example.javafxlogin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlogin to javafx.fxml;
    exports com.example.javafxlogin;
}