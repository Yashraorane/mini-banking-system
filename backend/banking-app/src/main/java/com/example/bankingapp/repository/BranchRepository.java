package com.example.bankingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bankingapp.model.Branch;

import java.util.Optional;

public interface BranchRepository extends MongoRepository<Branch, String> {

    Optional<Branch> findByBranchCode(String branchCode);
}
