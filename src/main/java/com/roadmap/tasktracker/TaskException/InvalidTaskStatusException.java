package com.roadmap.tasktracker.TaskException;

public class InvalidTaskStatusException extends Exception{
    public InvalidTaskStatusException(String status){
        super("Invalid Status: " + status);
    }
}
