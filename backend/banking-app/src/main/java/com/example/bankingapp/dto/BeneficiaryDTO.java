package com.example.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;

public class BeneficiaryDTO {

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Branch code is required")
    private String branchCode;

    private String nickname;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
