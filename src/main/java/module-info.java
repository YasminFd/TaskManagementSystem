module com.example.demons {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demons to javafx.fxml;
    exports com.example.demons;
    exports com.example.demons.Controllers;
    exports com.example.demons.enums;
    exports com.example.demons.Controllers.TaskController;

    // other module configurations
}
