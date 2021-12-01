module com.example.portapantry {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

<<<<<<< HEAD

    requires org.controlsfx.controls;

    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;

=======
    opens com.example.portapantry to javafx.fxml;
    exports com.example.portapantry;
>>>>>>> cbc0a7c69b4c6611d5d41c809afe784e4cff3a56
}