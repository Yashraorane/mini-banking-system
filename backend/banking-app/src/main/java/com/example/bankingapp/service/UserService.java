package com.example.bankingapp.service;

import com.example.bankingapp.model.User;
import com.example.bankingapp.repository.UserRepository;
import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.RoleRepository;
import com.example.bankingapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuditLogService auditLogService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        // Set default role if roles are not provided
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Role defaultRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Default role 'USER' not found"));
            user.getRoles().add(defaultRole.getName()); // Add role name as a string
        }

        User createdUser = userRepository.save(user);
        auditLogService.createAuditLog(new AuditLog("CREATE_USER", "admin", "Created user with ID: " + createdUser.getId()));
        return createdUser;
    }

    public Optional<User> updateUser(String id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEnabled(userDetails.isEnabled());
            user.setRoles(userDetails.getRoles());
            user.setAccounts(userDetails.getAccounts());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            auditLogService.createAuditLog(new AuditLog("DELETE_USER", "admin", "Deleted user with ID: " + id));
            return true;
        }
        return false;
    }
}
