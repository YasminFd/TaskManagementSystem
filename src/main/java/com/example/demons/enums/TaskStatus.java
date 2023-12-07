package com.example.demons.enums;

public enum TaskStatus {
    //enum to define constant status of Tasks
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    OVERDUE("Overdue");

    private final String statusText;

    TaskStatus(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return statusText;
    }
}
