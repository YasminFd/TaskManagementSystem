package com.example.demons.enums;

public enum TaskStatus {
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String statusText;

    TaskStatus(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return statusText;
    }
}
