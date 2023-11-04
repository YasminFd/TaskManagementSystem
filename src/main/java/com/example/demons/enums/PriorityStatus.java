package com.example.demons.enums;

public enum PriorityStatus {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String statusText;

    PriorityStatus(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return statusText;
    }
}
