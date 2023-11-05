package com.example.demons.Comparators;

import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;

import java.util.Comparator;

import java.util.Comparator;


    public class NormalTaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            // Get the statuses of the tasks
            TaskStatus status1 = o1.getStatus();
            TaskStatus status2 = o2.getStatus();

            // Check for "COMPLETED" and "IN_PROGRESS" statuses
            if (status1 == TaskStatus.COMPLETED && status2 != TaskStatus.COMPLETED) {
                return 1; // o1 is considered greater
            } else if (status1 != TaskStatus.COMPLETED && status2 == TaskStatus.COMPLETED) {
                return -1; // o2 is considered greater
            } else if (status1 == TaskStatus.IN_PROGRESS && status2 != TaskStatus.IN_PROGRESS) {
                return -1; // o1 is considered greater
            } else if (status1 != TaskStatus.IN_PROGRESS && status2 == TaskStatus.IN_PROGRESS) {
                return 1; // o2 is considered greater
            } else {
                return o1.compareTo(o2); // Both tasks have the same status check created_date
            }
        }
    }


