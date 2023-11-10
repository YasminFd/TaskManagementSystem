package com.example.demons.TaskFXMLFactory;

import com.example.demons.enums.TaskType;

public class TaskFXMLFactory{
    private TaskFXMLLoader taskFactory;
    public TaskFXMLLoader Load_View(TaskType T){
        switch (T) {//depending on each type use the needed factory
            case ToDo:
                taskFactory = new ToDoTaskLoader();
                break;
            case PRIORITISED:
                taskFactory = new PrioritisedTaskLoader();
                break;
            case DEADLINE:
                taskFactory = new TimedTaskLoader();
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }
        return taskFactory;
    }
}
