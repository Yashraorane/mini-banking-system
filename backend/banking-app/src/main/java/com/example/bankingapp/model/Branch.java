package com.example.bankingapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "branches")
public class Branch {

    @Id
    private String id;

    @Indexed(unique = true)
    private String branchCode;

    private String name;

    private String address;

    private String contactNumber;

    public Branch() {
    }

    public Branch(String branchCode, String name, String address, String contactNumber) {
        this.branchCode = branchCode;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
