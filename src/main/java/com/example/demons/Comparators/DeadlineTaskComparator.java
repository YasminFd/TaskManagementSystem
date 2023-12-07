package com.example.demons.Comparators;

import com.example.demons.Models.Task;

import java.util.Comparator;
import java.util.Date;

public class DeadlineTaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        Date a=(Date)o1.getProperty();
        Date b=(Date)o2.getProperty();
        return a.compareTo(b);
    }
    //customised comparison based on the deadline of Task
    // -> for sorting Tasks of type Deadline
}
