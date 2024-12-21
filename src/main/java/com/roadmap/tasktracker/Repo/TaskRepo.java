package com.roadmap.tasktracker.Repo;

import com.roadmap.tasktracker.Tasks.MyTasks;
import com.roadmap.tasktracker.Tasks.MyTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<MyTasks, Long> {
    List<MyTasks> findByStatus(MyTaskStatus status);
}
