module com.example.rupizza {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.rupizza to javafx.fxml;
    exports com.example.rupizza;
    exports com.example.rupizza.Controllers;
    opens com.example.rupizza.Controllers to javafx.fxml;
}