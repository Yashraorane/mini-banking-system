package com.example.bankingapp.controller;

import com.example.bankingapp.dto.AccountDTO;
import com.example.bankingapp.model.Account;
import com.example.bankingapp.model.AccountType;
import com.example.bankingapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        try {
            Account account = new Account();
            account.setAccountNumber(accountDTO.getAccountNumber());
            account.setBalance(accountDTO.getBalance());
            account.setType(AccountType.valueOf(accountDTO.getType().toUpperCase())); // Convert String to AccountType enum
            account.setUserId(accountDTO.getUserId());
            // Branch will be set in the service layer if needed
            return ResponseEntity.ok(accountService.createAccount(account));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Invalid account type
        }
    }

    // Get an account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an account by ID
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable String id, @Valid @RequestBody AccountDTO accountDTO) {
        try {
            Account accountDetails = new Account();
            accountDetails.setAccountNumber(accountDTO.getAccountNumber());
            accountDetails.setBalance(accountDTO.getBalance());
            accountDetails.setType(AccountType.valueOf(accountDTO.getType().toUpperCase())); // Convert String to AccountType enum
            accountDetails.setUserId(accountDTO.getUserId());
            // Branch will be set in the service layer if needed
            return accountService.updateAccount(id, accountDetails).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Invalid account type
        }
    }

    // Delete an account by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        if (accountService.deleteAccount(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
