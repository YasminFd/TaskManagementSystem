package com.example.demons.AddTaskProxy;

import com.example.demons.Models.Task;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.util.Date;
import java.util.function.Predicate;

public class TaskProxy implements DeadlineTaskCreator{
    //proxy task created instead of task at first to check its validity
    private Task<Date> RealTask;

    public Task<Date> getRealTask() {
        return RealTask;
    }

    @Override
    public int AddTask(String title, String description, Date deadline) throws Exception {
        if(!checkDate(deadline)){
            this.RealTask = new Task(-1, TaskType.DEADLINE,title,description, TaskStatus.IN_PROGRESS,deadline,new java.util.Date());
            return RealTask.AddTask(title,description,deadline);
        }
        else{
                Notifications notification = Notifications.create()
                        .title("Alert")
                        .text("Date Already Passed!")
                        .hideAfter(Duration.seconds(3))
                        .position(Pos.TOP_CENTER);
                notification.show();

            throw new Exception("Date Already Passed");
        }
    }
    boolean checkDate(Date d){
        Predicate<Date> dateHasPassed = (date) -> date.before(new java.util.Date());
        return dateHasPassed.test(d);
    }

}
