package com.example.task_management_api.dto;
import com.example.task_management_api.entity.TaskPriority;
import com.example.task_management_api.entity.TaskStatus;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class TaskRequest {
  @NotBlank
  @Size(max = 255)
  private String title;

  @Size(max = 1000)
  private String description;

  private TaskStatus status = TaskStatus.TODO;

  private TaskPriority priority = TaskPriority.MEDIUM;

  private LocalDateTime dueDate;

  public TaskRequest() {}

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public TaskStatus getStatus() {
    return status;
  }
  public void setStatus(TaskStatus status) {
    this.status = status;
  }
  public TaskPriority getPriority() {
    return priority;
  }
  public void setPriority(TaskPriority priority) {
    this.priority = priority;
  }
  public LocalDateTime getDueDate() {
    return dueDate;
  }
  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }
}
