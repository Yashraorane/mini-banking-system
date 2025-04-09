package com.example.bankingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bankingapp.model.Beneficiary;

import java.util.List;

public interface BeneficiaryRepository extends MongoRepository<Beneficiary, String> {

    List<Beneficiary> findByUserId(String userId);

    boolean existsByUserIdAndAccountNumber(String userId, String accountNumber);
}
