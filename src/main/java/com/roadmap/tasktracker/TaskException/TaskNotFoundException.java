package com.roadmap.tasktracker.TaskException;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(Long taskId){
        super("Task Not Found with id: " + taskId);
    }
}
