package com.example.task_management_api.controller;
import com.example.task_management_api.entity.User;
import com.example.task_management_api.dto.RegisterRequest;
import com.example.task_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserService userService;

  //Register new user
  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody @Valid RegisterRequest request) {
    try{
      User user = userService.registerUser(request);
      return ResponseEntity.ok(user);
    } catch (RuntimeException e){
      return ResponseEntity.badRequest().build();
    }
  }
  //Get User by their email
  @GetMapping("/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    return userService.findUserByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
}
