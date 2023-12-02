package com.example.demons.Controllers.TaskController;

import com.example.demons.Decorator.DeadlineTaskDecorator;
import com.example.demons.Decorator.PrioritisedTaskDecorator;
import com.example.demons.Decorator.SuperViewTask;
import com.example.demons.Models.Task;

public interface LoadView {
    public static void initializeView(Task Task, ViewTaskController Controller) {

        System.out.println("Viewing:\n" + Task);
        switch (Task.getType()) {
            case ToDo:
                SuperViewTask a = new SuperViewTask<TaskController>();
                a.setFullView(Controller);
                break;
            case PRIORITISED:
                PrioritisedTaskDecorator b = new PrioritisedTaskDecorator();
                b.setFullView(Controller);
                break;
            case DEADLINE:
                DeadlineTaskDecorator c = new DeadlineTaskDecorator();
                c.setFullView(Controller);
                break;
            default:
                throw new IllegalArgumentException("Unsupported task type");
        }

    }
}
