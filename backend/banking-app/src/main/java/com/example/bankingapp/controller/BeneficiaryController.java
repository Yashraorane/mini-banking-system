package com.example.bankingapp.controller;

import com.example.bankingapp.dto.BeneficiaryDTO;
import com.example.bankingapp.model.Beneficiary;
import com.example.bankingapp.service.BeneficiaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    // Get all beneficiaries for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Beneficiary>> getBeneficiariesByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(beneficiaryService.getBeneficiariesByUserId(userId));
    }

    // Add a new beneficiary
    @PostMapping
    public ResponseEntity<Beneficiary> addBeneficiary(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setUserId(beneficiaryDTO.getUserId());
        beneficiary.setAccountNumber(beneficiaryDTO.getAccountNumber());
        // Branch will be set in the service layer if needed
        beneficiary.setNickname(beneficiaryDTO.getNickname());
        return ResponseEntity.ok(beneficiaryService.createBeneficiary(beneficiary));
    }

    // Update a beneficiary's nickname
    @PutMapping("/{id}")
    public ResponseEntity<Beneficiary> updateBeneficiaryNickname(@PathVariable String id, @RequestBody String nickname) {
        return beneficiaryService.updateBeneficiary(id, nickname).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a beneficiary by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiary(@PathVariable String id) {
        if (beneficiaryService.deleteBeneficiary(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
