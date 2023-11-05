package com.example.demons.Comparators;

import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;

import java.util.Comparator;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;

import java.util.Comparator;

public class PriorityTaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        // Get the priorities of the tasks
        PriorityStatus priority1 = (PriorityStatus) o1.getProperty();
        PriorityStatus priority2 = (PriorityStatus) o2.getProperty();

        // Check for priorities
        if (priority1 == PriorityStatus.HIGH && priority2 != PriorityStatus.HIGH) {
            return 1; // o1 is considered greater
        } else if (priority1 != PriorityStatus.HIGH && priority2 == PriorityStatus.HIGH) {
            return -1; // o2 is considered greater
        } else if (priority1 == PriorityStatus.MEDIUM && priority2 != PriorityStatus.MEDIUM) {
            return -1; // o1 is considered greater
        } else if (priority1 != PriorityStatus.MEDIUM && priority2 == PriorityStatus.MEDIUM) {
            return 1; // o2 is considered greater
        } else if (priority1 == PriorityStatus.LOW && priority2 != PriorityStatus.LOW) {
            return -1; // o1 is considered greater
        } else if (priority1 != PriorityStatus.LOW && priority2 == PriorityStatus.LOW) {
            return 1; // o2 is considered greater
        } else {
            return o1.compareTo(o2); // Both tasks have the same priority, check created_date
        }
    }
}
