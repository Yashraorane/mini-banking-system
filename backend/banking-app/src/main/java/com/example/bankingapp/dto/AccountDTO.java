package com.example.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class AccountDTO {

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotNull(message = "Balance is required")
    private BigDecimal balance;

    @NotBlank(message = "Account type is required")
    private String type;

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Branch ID is required")
    private String branchId;

    // Getters and Setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}