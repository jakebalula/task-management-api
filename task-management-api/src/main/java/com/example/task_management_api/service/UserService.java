package com.example.task_management_api.service;
import com.example.task_management_api.entity.User;
import com.example.task_management_api.dto.RegisterRequest;
import com.example.task_management_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User registerUser(RegisterRequest request) {
    //This checks if the user exists already
    if (userRepository.existsByEmail(request.getEmail())){
      throw new RuntimeException("User already exists");
    }
    //Create new user
    User user = new User();
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());

    return userRepository.save(user);
  }
  public Optional<User> findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
  public Optional<User> findUserById(Long id) {
    return userRepository.findById(id);
  }
}
