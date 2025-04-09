package com.example.bankingapp.dto;

import com.example.bankingapp.model.TransactionType;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransactionDTO {

    @NotNull(message = "Source account ID is required")
    private String sourceAccountId;

    @NotNull(message = "Target account ID is required")
    private String targetAccountId;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @NotNull(message = "Transaction type is required")
    private TransactionType type; // Use enum instead of String

    private String status;

    // Getters and Setters
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
}