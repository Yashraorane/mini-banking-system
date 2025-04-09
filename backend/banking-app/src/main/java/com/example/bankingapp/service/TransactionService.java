package com.example.bankingapp.service;

import com.example.bankingapp.model.Transaction;
import com.example.bankingapp.model.TransactionType;
import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AuditLogService auditLogService;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        Transaction createdTransaction = transactionRepository.save(transaction);
        auditLogService.createAuditLog(new AuditLog(
            "CREATE_TRANSACTION",
            transaction.getSourceAccountId(),
            "Transaction of type '" + transaction.getType() + "' from account " +
            transaction.getSourceAccountId() + " to account " + transaction.getTargetAccountId() +
            " for amount " + transaction.getAmount()
        ));
        return createdTransaction;
    }

    public List<Transaction> getTransactionsBySourceAccount(String sourceAccountId) {
        return transactionRepository.findBySourceAccountId(sourceAccountId);
    }

    public List<Transaction> getTransactionsByTargetAccount(String targetAccountId) {
        return transactionRepository.findByTargetAccountId(targetAccountId);
    }

    public List<Transaction> getTransactionsByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }
}
