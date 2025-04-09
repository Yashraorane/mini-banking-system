package com.example.bankingapp.dto;

import jakarta.validation.constraints.NotBlank;

public class BranchDTO {

    @NotBlank(message = "Branch code is required")
    private String branchCode;

    @NotBlank(message = "Branch name is required")
    private String name;

    private String address;

    private String contactNumber;

    // Getters and Setters
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
