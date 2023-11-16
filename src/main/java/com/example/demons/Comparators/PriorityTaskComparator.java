package com.example.demons.Comparators;

import com.example.demons.Models.Task;
import com.example.demons.enums.PriorityStatus;

import java.util.Comparator;

public class PriorityTaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        // Get the priorities of the tasks
        PriorityStatus priority1 = (PriorityStatus) o1.getProperty();
        PriorityStatus priority2 = (PriorityStatus) o2.getProperty();

        // Assign integer values to priorities for easier comparison
        int value1 = getPriorityValue(priority1);
        int value2 = getPriorityValue(priority2);

        // Compare based on priorities
        return Integer.compare(value1, value2);
        //customised comparision based on the priority of Task
        // -> for sorting Tasks of priority type only
        // Low < Medium < High
    }

    // Helper method to assign integer values to priorities
    private int getPriorityValue(PriorityStatus priority) {
        switch (priority) {
            case HIGH:
                return 3;
            case MEDIUM:
                return 2;
            case LOW:
                return 1;
            default:
                return 0; // Default case for unexpected priorities
        }
    }

}
