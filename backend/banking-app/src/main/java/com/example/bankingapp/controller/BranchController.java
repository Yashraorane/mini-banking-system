package com.example.bankingapp.controller;

import com.example.bankingapp.dto.BranchDTO;
import com.example.bankingapp.model.Branch;
import com.example.bankingapp.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Get all branches
    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    // Create a new branch
    @PostMapping
    public ResponseEntity<Branch> createBranch(@Valid @RequestBody BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setBranchCode(branchDTO.getBranchCode());
        branch.setName(branchDTO.getName());
        branch.setAddress(branchDTO.getAddress());
        branch.setContactNumber(branchDTO.getContactNumber());
        return ResponseEntity.ok(branchService.createBranch(branch));
    }

    // Get a branch by branch code
    @GetMapping("/{branchCode}")
    public ResponseEntity<Branch> getBranchByBranchCode(@PathVariable String branchCode) {
        return branchService.getBranchByBranchCode(branchCode).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a branch by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable String id) {
        if (branchService.deleteBranch(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
