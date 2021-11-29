module com.example.portapantry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    requires org.controlsfx.controls;
    requires mysql.connector.java;

    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;

}