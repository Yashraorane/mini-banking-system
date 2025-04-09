package com.example.bankingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "beneficiaries")
public class Beneficiary {

    @Id
    private String id;

    @Indexed
    private String userId; // Index for efficient querying by user

    @Indexed(unique = true)
    private String accountNumber; // Ensure account numbers are unique for beneficiaries

    @DBRef
    private Branch branch; // Reference to the branch

    private String nickname; // Optional nickname for the beneficiary

    public Beneficiary() {
    }

    public Beneficiary(String userId, String accountNumber, Branch branch, String nickname) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.nickname = nickname;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
