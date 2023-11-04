package com.example.demons.Models;

import com.example.demons.enums.TaskStatus;

import java.util.Date;
import java.util.Optional;

public class Task <T> implements Comparable<Task>{
    private int ID;
    private String Title;
    private String Description;
    private TaskStatus status;
    private int type;
    private T Property;
    private Date created_at;


    public Task(int ID,int type, String title, String description, TaskStatus status, T property, Date created_at) {
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

    public int getType() {
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

    public void setType(int type) {
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
}
