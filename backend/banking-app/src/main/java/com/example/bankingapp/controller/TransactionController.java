package com.example.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.TransactionType;
import com.example.bankingapp.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Create a new transaction
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    // Get transactions by source account ID
    @GetMapping("/source/{sourceAccountId}")
    public ResponseEntity<List<Transaction>> getTransactionsBySourceAccount(@PathVariable String sourceAccountId) {
        List<Transaction> transactions = transactionService.getTransactionsBySourceAccount(sourceAccountId);
        return ResponseEntity.ok(transactions);
    }

    // Get transactions by target account ID
    @GetMapping("/target/{targetAccountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByTargetAccount(@PathVariable String targetAccountId) {
        List<Transaction> transactions = transactionService.getTransactionsByTargetAccount(targetAccountId);
        return ResponseEntity.ok(transactions);
    }

    // Get transactions by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@PathVariable String type) {
        try {
            TransactionType transactionType = TransactionType.valueOf(type.toUpperCase());
            List<Transaction> transactions = transactionService.getTransactionsByType(transactionType);
            return ResponseEntity.ok(transactions);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // Invalid transaction type
        }
    }
}
