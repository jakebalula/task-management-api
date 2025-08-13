package com.example.task_management_api.controller;
import com.example.task_management_api.entity.Task;
import com.example.task_management_api.entity.User;
import com.example.task_management_api.entity.TaskStatus;
import com.example.task_management_api.entity.TaskPriority;
import com.example.task_management_api.dto.TaskRequest;
import com.example.task_management_api.service.TaskService;
import com.example.task_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins ="*")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @Autowired
  private UserService userService;

  //New task
  @PostMapping
  public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest request, @RequestHeader("User-Id") Long userId) {
    Optional<User> user = userService.findUserById(userId);
    if (user.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    Task task = taskService.createTask(request, user.get());
    return ResponseEntity.ok(task);
  }

  //Get all tasks
  @GetMapping
  public ResponseEntity<List<Task>> getUserTasks(@RequestHeader("User-Id") Long userId) {
    List<Task> tasks = taskService.getUserTasks(userId);
    return ResponseEntity.ok(tasks);
  }
  //Get a specific task
  @GetMapping("/{id}")
  public ResponseEntity<Task> getTask(@PathVariable Long id, @RequestHeader ("User-Id") Long userId) {
    Optional<Task> task = taskService.getUserTask(id, userId);
    return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
  //Get tasks by status
  @GetMapping("/status/{status}")
  public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status, @RequestHeader("User-Id") Long userId) {
    List<Task> tasks = taskService.getTasksByStatus(status, userId);
    return ResponseEntity.ok(tasks);
  }
  //Get tasks by priority
  @GetMapping("/priority/{priority}")
  public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable TaskPriority priority, @RequestHeader("User-Id") Long userId) {
    List<Task> tasks = taskService.getTasksByPriority(priority, userId);
    return ResponseEntity.ok(tasks);
  }
  //Updating a task
  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequest request, @RequestHeader("User-Id") Long userId) {
    Optional<Task> taskOpt = taskService.getUserTask(id, userId);
    if (taskOpt.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    Task updatedTask = taskService.updateTask(taskOpt.get(), request);
    return ResponseEntity.ok(updatedTask);
  }
  //Deleting a task
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable Long id, @RequestHeader("User-Id") Long userId) {
    Optional<Task> task = taskService.getUserTask(id, userId);
    if (task.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    taskService.deleteTask(task.get());
    return ResponseEntity.noContent().build();
  }
}
