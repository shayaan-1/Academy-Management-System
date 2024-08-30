module com.example.fxwalaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fxwalaproject to javafx.fxml;
    exports com.example.fxwalaproject;
}