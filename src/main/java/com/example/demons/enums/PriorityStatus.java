package com.example.demons.enums;

public enum PriorityStatus {
    //enum to define constant status of Priorities
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
    //return status based on its string value
    public static PriorityStatus fromString(String label) {
        for (PriorityStatus status : PriorityStatus.values()) {
            if (status.getStatusText().equalsIgnoreCase(label)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No constant with label " + label + " found");
    }

}
