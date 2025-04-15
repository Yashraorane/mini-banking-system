package com.example.bankingapp.controller;

import com.example.bankingapp.dto.UserDTO;
import com.example.bankingapp.model.User;
import com.example.bankingapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000") // Allow frontend origin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Removed unused UserRepository field

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a new user (used for registration as well)
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        return createUser(userDTO); // Reuse the createUser method
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEnabled(userDTO.isEnabled());
        user.setAccounts(userDTO.getAccounts());
        // Roles will be set in the service layer if needed
        return ResponseEntity.ok(userService.createUser(user));
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user by ID
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @Valid @RequestBody UserDTO userDTO) {
        User userDetails = new User();
        userDetails.setUsername(userDTO.getUsername());
        userDetails.setPassword(userDTO.getPassword());
        userDetails.setEmail(userDTO.getEmail());
        userDetails.setFirstName(userDTO.getFirstName());
        userDetails.setLastName(userDTO.getLastName());
        userDetails.setEnabled(userDTO.isEnabled());
        userDetails.setAccounts(userDTO.getAccounts());
        // Roles will be set in the service layer if needed
        return userService.updateUser(id, userDetails).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (userService.deleteUser(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
