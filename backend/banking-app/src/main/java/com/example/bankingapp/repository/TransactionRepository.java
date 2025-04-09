package com.example.bankingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.TransactionType;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findBySourceAccountId(String sourceAccountId);

    List<Transaction> findByTargetAccountId(String targetAccountId);

    List<Transaction> findByType(TransactionType type); // Query by enum type
}
