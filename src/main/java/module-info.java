module com.example.portapantry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;
}