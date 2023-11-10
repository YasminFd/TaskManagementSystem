module com.example.demons {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;


    opens com.example.demons to javafx.fxml;
    opens com.example.demons.Controllers;
    exports com.example.demons;
    exports com.example.demons.Controllers;
    exports com.example.demons.enums;
    exports com.example.demons.Controllers.TaskController;
    exports com.example.demons.Controllers.AddTaskController;
    opens com.example.demons.Controllers.AddTaskController;


    // other module configurations
}
