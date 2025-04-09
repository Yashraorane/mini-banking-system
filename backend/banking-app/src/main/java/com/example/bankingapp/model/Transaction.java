package com.example.bankingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    @Indexed
    private String sourceAccountId; // Index for efficient querying by source account

    @Indexed
    private String targetAccountId; // Index for efficient querying by target account

    private BigDecimal amount;

    private TransactionType type; // Use enum instead of String

    private String status; // SUCCESS, FAILED, PENDING

    @DBRef
    private Branch branch; // Reference to the Branch

    @Indexed
    @CreatedDate
    private LocalDateTime timestamp; // Index for querying by transaction time

    public Transaction() {
    }

    public Transaction(String sourceAccountId, String targetAccountId, BigDecimal amount, TransactionType type, String status, Branch branch) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.branch = branch;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(String targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
