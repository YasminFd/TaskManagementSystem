package com.example.demons.LambdaInterfaces;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public interface StatusLambdaServices {
    public static StatusSetter<Circle> setCompleted = (p)->{
        //set status color to green and text to Completed
        String style ="-fx-stroke: transparent;        /* Stroke (border) color */\n" +
                "    -fx-stroke-type: inside;        /* Stroke type (INSIDE) */\n" +
                "    -fx-stroke-width: 1;            /* Stroke width */\n" +
                "    -fx-radius: 10.0; ";
        style += "-fx-fill: green;";
        p.setStyle(style);
    };

    public static StatusSetter<Circle> setInProgress = ( p)->{
        //set status color to red and text to Im Progress
        String style ="-fx-stroke: transparent;        /* Stroke (border) color */\n" +
                "    -fx-stroke-type: inside;        /* Stroke type (INSIDE) */\n" +
                "    -fx-stroke-width: 1;            /* Stroke width */\n" +
                "    -fx-radius: 10.0; ";
        style += "-fx-fill: red;";
        p.setStyle(style);
    };

    public static StatusSetter<Circle> setOverDue = (p)->{
        //set status color to grey and text to Overdue
        String style ="-fx-stroke: transparent;        /* Stroke (border) color */\n" +
                "    -fx-stroke-type: inside;        /* Stroke type (INSIDE) */\n" +
                "    -fx-stroke-width: 1;            /* Stroke width */\n" +
                "    -fx-radius: 10.0; ";
        style += "-fx-fill: grey;";
        p.setStyle(style);
    };

    public static StatusSetter<Label> setLOW = (p)->{
        //set Status label to green color with text Low
        p.setText("LOW");
        p.setStyle("-fx-text-fill: green; -fx-font-weight: bold;"); // Set the text color to yellow
    };

    public static StatusSetter<Label> setMEDIUM = ( p)->{
        // set status label to yellow with text Medium
        p.setText("MEDIUM");
        p.setStyle("-fx-text-fill: yellow; -fx-font-weight: bold;");
    };

    public static StatusSetter<Label> setHIGH = ( p)->{
        //set status label to red with text High
        p.setText("HIGH");
        p.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    };
}
