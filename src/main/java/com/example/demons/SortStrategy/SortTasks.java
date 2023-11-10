package com.example.demons.SortStrategy;

import com.example.demons.Models.Task;

import java.util.ArrayList;

public interface SortTasks {
    /*. In order to be able to encapsulate the sort logic in one interface and be
able to define different strategies to sort the tasks with consideration of the addition of new sorting
options without modifying existing code, strategy pattern is needed.*/
    public void sort(ArrayList<Task> T);
}
