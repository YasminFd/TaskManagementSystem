package com.example.demons.enums;

public enum TaskType {
    //enum to define constant types oF Tasks

    ToDo("ToDo"),
    PRIORITISED("Prioritised"),
    DEADLINE("Deadline")
    ;

    private final String typeText;

    TaskType(String statusText) {
        this.typeText = statusText;
    }



    public String getTypeText() {
        return typeText;
    }
    //return status based on its string value
    public static TaskType fromString(String label) {
        for (TaskType type : TaskType.values()) {
            if (type.getTypeText().equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with label " + label + " found");
    }

}
