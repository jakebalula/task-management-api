package com.example.task_management_api.service;
import com.example.task_management_api.entity.Task;
import com.example.task_management_api.entity.User;
import com.example.task_management_api.entity.TaskPriority;
import com.example.task_management_api.entity.TaskStatus;
import com.example.task_management_api.dto.TaskRequest;
import com.example.task_management_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
  @Autowired
  private TaskRepository taskRepository;

  public Task createTask(TaskRequest request, User user) {
    Task task = new Task();
    task.setTitle(request.getTitle());
    task.setDescription(request.getDescription());
    task.setPriority(request.getPriority());
    task.setDueDate(request.getDueDate());
    task.setUser(user);

    return taskRepository.save(task);
  }

  public List<Task> getUserTasks(Long userId) {
    return taskRepository.findByUserIdOrderByCreatedAtDesc(userId);
  }

  public Optional<Task> getUserTask(Long taskId, Long userId) {
    return taskRepository.findByIdAndUserId(taskId, userId);
  }

  public Task updateTask(Task task, TaskRequest request){
    task.setTitle(request.getTitle());
    task.setDescription(request.getDescription());
    task.setPriority(request.getPriority());
    task.setDueDate(request.getDueDate());
    task.setStatus(task.getStatus());

    return taskRepository.save(task);
  }

  public void deleteTask(Task task){
    taskRepository.delete(task);
  }

  public List<Task> getTasksByStatus(TaskStatus status, Long userId) {
    return taskRepository.findByUserIdAndStatus(userId, status);
  }

  public List<Task> getTasksByPriority(TaskPriority priority, Long userId) {
    return taskRepository.findByUserIdAndPriority(userId, priority);
  }
}
