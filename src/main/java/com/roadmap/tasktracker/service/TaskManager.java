package com.roadmap.tasktracker.service;

import com.roadmap.tasktracker.Repo.TaskRepo;
import com.roadmap.tasktracker.Tasks.MyTasks;
import com.roadmap.tasktracker.Tasks.MyTaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManager {

    @Autowired
    private TaskRepo taskRepository;

    public MyTasks addTask(MyTasks task) {
        task.setStatus(MyTaskStatus.TODO);
        return taskRepository.save(task);
    }

    public MyTasks updateTask(Long id, MyTasks updatedTask) {
        Optional<MyTasks> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            MyTasks task = taskOptional.get();
            task.setName(updatedTask.getName());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<MyTasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<MyTasks> getTasksByStatus(MyTaskStatus status) {
        return taskRepository.findByStatus(status);
    }
}
