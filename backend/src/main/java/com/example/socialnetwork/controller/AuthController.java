package com.example.socialnetwork.controller;

import com.example.socialnetwork.dto.LoginRequest;
import com.example.socialnetwork.dto.RegisterRequest;
import com.example.socialnetwork.model.User;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Добавьте этот импорт

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository; // Добавляем UserRepository

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository; // Инициализируем UserRepository
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.registerUser(request.getUsername(), request.getPassword(), request.getEmail());
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.authenticateUser(request.getUsername(), request.getPassword());
    }

    @GetMapping("/profile/{id}")
    public User getProfile(@PathVariable Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/users")
        public List<User> getAllUsers() {
    return userRepository.findAll();
    }

}