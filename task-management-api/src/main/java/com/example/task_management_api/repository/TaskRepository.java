package com.example.task_management_api.repository;
import com.example.task_management_api.entity.Task;
import com.example.task_management_api.entity.TaskStatus;
import com.example.task_management_api.entity.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByUserIdOrderByCreatedAtDesc(Long userId);
  Optional<Task> findByIdAndUserId(Long id, Long userId);
  List<Task> findByUserIdAndStatus(Long userId, TaskStatus status);
  List<Task> findByUserIdAndPriority(Long userId, TaskPriority priority);
}
