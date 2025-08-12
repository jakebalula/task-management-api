package com.example.task_management_api.dto;
import jakarta.validation.constraints.*;

public class RegisterRequest {
  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 6)
  private String password;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  public RegisterRequest(){}

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
