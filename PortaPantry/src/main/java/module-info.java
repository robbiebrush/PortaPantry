module com.example.portapantry {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;
}