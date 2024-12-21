package com.roadmap.tasktracker.controller;

import com.roadmap.tasktracker.TaskException.*;
import com.roadmap.tasktracker.Tasks.MyTasks;
import com.roadmap.tasktracker.Tasks.MyTaskStatus;
import com.roadmap.tasktracker.service.TaskManager;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myTasks")
public class MyTaskController {

    @Autowired
    private TaskManager taskManager;

    @PostMapping
    @Operation(summary = "addTask")
    public ResponseEntity<MyTasks> addTask(@RequestBody MyTasks task) {
        return ResponseEntity.ok(taskManager.addTask(task));
    }

    @PutMapping("/{id}")
    @Operation(summary = "updateTask")
    public ResponseEntity<MyTasks> updateTask(@PathVariable Long id, @RequestBody MyTasks task)
            throws TaskNotFoundException, InvalidTaskStatusException {
        return ResponseEntity.ok(taskManager.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "deleteTask")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws TaskNotFoundException {
        taskManager.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "getAllTasks")
    public ResponseEntity<List<MyTasks>> getAllTasks() {
        return ResponseEntity.ok(taskManager.getAllTasks());
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "getTasksByStatus")
    public ResponseEntity<List<MyTasks>> getTasksByStatus(@PathVariable MyTaskStatus status)
            throws InvalidTaskStatusException {
        return ResponseEntity.ok(taskManager.getTasksByStatus(status));
    }
}
