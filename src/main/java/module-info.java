module com.example.portapantry {
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< HEAD
    requires java.sql;


    requires org.controlsfx.controls;
    requires mysql.connector.java;

    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;

=======

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
}