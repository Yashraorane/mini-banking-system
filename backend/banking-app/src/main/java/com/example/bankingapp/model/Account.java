package com.example.bankingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "accounts")
public class Account {

    @Id
    private String id;

    @Indexed(unique = true)
    private String accountNumber; // Ensure account numbers are unique

    private BigDecimal balance = BigDecimal.ZERO;

    private AccountType type;

    private String userId; // Reference to the User

    @DBRef
    private Branch branch; // Reference to the Branch

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private List<String> outgoingTransactions; // References to outgoing transactions
    private List<String> incomingTransactions; // References to incoming transactions

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(List<String> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public List<String> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(List<String> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }
}
