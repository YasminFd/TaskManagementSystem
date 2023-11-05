package com.example.demons.LambdaInterfaces;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public interface StatusLambdaServices {
    public static StatusSetter<Pane> setCompleted = (p)->{
        String style = "-fx-border-width: 20; -fx-border-style: solid; -fx-border-radius: 20px ;";
        style += "-fx-border-color: green;";
        p.setStyle(style);
    };

    public static StatusSetter<Pane> setInProgress = ( p)->{
        String style = "-fx-border-width: 20; -fx-border-style: solid; -fx-border-radius: 20px ;";
        style += "-fx-border-color: red;";
        p.setStyle(style);
    };

    public static StatusSetter<Pane> setOverDue = (p)->{
        String style = "-fx-border-width: 20; -fx-border-style: solid; -fx-border-radius: 20px ;";
        style += "-fx-border-color: grey;";
        p.setStyle(style);
    };

    public static StatusSetter<Label> setLOW = (p)->{
        p.setText("LOW");
        p.setStyle("-fx-text-fill: green; -fx-font-weight: bold;"); // Set the text color to yellow
    };

    public static StatusSetter<Label> setMEDIUM = ( p)->{
        p.setText("MEDIUM");
        p.setStyle("-fx-text-fill: yellow; -fx-font-weight: bold;");
    };

    public static StatusSetter<Label> setHIGH = ( p)->{
        p.setText("HIGH");
        p.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    };
}
