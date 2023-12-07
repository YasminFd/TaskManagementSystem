package com.example.demons.Models;

import com.example.demons.AddTaskProxy.DeadlineTaskCreator;
import com.example.demons.DbConnection;
import com.example.demons.enums.TaskStatus;
import com.example.demons.enums.TaskType;

import java.sql.SQLException;
import java.util.Date;
//provide a versatile and reusable abstraction,
// enabling the creation of classes and functions that
// can operate on a variety of data types, promoting code
// flexibility and reducing redundancy.






public class Task <T > implements Comparable<Task>, DeadlineTaskCreator {//to customise compare To
    //Generis Class
    private int ID;
    private String Title;
    private String Description;
    private TaskStatus status;
    private TaskType type;
    private T Property;// generic property depending on task type needed
    // defined as a Date for tasks with Deadlines, PriorityStatus for prioritised tasks
    //null for normal To Do Tasks
    private Date created_at;


    public Task(int ID,TaskType type, String title, String description, TaskStatus status, T property, Date created_at) {
        this.ID = ID;
        this.type=type;
        Title = title;
        Description = description;
        this.status = status;
        Property =  property;
        this.created_at = created_at;
    }

    public String getTitle() {
        return Title;
    }

    public TaskType getType() {
        return type;
    }

    public String getDescription() {
        return Description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public T getProperty() {
        return (T) Property;
    }

    public int getID() {
        return ID;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setProperty(T property) {
        Property =  property;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    //compare tasks by creation date
    @Override
    public int compareTo(Task o) {
        return this.getCreated_at().compareTo(o.getCreated_at());
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", Property=" + Property +
                ", created_at=" + created_at +
                '}'+'\n';
    }

    @Override
    public int AddTask(String title, String description, Date deadline) throws SQLException {
        DbConnection dbConnection= DbConnection.getInstance();
        return dbConnection.addTask(new Task(-1, TaskType.DEADLINE,title,description, TaskStatus.IN_PROGRESS,deadline,new java.util.Date()));

    }
}
