package com.example.demons.FilterStrategy;

import com.example.demons.Models.Task;

import java.util.ArrayList;

public interface FilterTasks {
    /*. In order to be able to encapsulate the filter logic in one interface and be
able to define different strategies to filter the tasks with consideration of the addition of new filtering
options without modifying existing code, strategy pattern is needed.*/
    // same goal: flter task -> different approach: only to do tasks, only priorities, only deadlines
    public ArrayList<Task> filter();
}
