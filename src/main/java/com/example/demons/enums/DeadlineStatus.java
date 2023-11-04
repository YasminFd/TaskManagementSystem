package com.example.demons.enums;

public enum DeadlineStatus {
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    OVERDUE("Overdue");

    private final String statusText;

    DeadlineStatus(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return statusText;
    }
}
