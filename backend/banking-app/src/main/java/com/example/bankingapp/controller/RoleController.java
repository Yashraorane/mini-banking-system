package com.example.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bankingapp.model.Role;
import com.example.bankingapp.repository.RoleRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    // Create a new role
    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // Get a role by name
    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
        Optional<Role> role = roleRepository.findByName(name);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Check if a role exists by name
    @GetMapping("/exists/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable String name) {
        Boolean exists = roleRepository.findByName(name).isPresent();
        return ResponseEntity.ok(exists);
    }
}
