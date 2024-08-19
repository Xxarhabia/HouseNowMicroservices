package com.example.user.controller;

import com.example.user.entities.UserEntity;
import com.example.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        try {
            if (user == null) {
                throw new RuntimeException("User data is null");
            }
            return ResponseEntity.status(201).body(userService.createUser(user));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {
        try {
            if (id == null) {
                throw new RuntimeException("Id values is null");
            }
            return ResponseEntity.status(200).body(userService.findUserById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.status(200).body(userService.findUsers());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
}
