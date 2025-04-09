package com.example.bankingapp.service;

import com.example.bankingapp.model.Beneficiary;
import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private AuditLogService auditLogService;

    public List<Beneficiary> getBeneficiariesByUserId(String userId) {
        return beneficiaryRepository.findByUserId(userId);
    }

    public Beneficiary createBeneficiary(Beneficiary beneficiary) {
        Beneficiary createdBeneficiary = beneficiaryRepository.save(beneficiary);
        auditLogService.createAuditLog(new AuditLog("ADD_BENEFICIARY", beneficiary.getUserId(), "Added beneficiary with account number: " + createdBeneficiary.getAccountNumber()));
        return createdBeneficiary;
    }

    public Optional<Beneficiary> updateBeneficiary(String id, String nickname) {
        return beneficiaryRepository.findById(id).map(beneficiary -> {
            beneficiary.setNickname(nickname);
            return beneficiaryRepository.save(beneficiary);
        });
    }

    public boolean deleteBeneficiary(String id) {
        if (beneficiaryRepository.existsById(id)) {
            beneficiaryRepository.deleteById(id);
            auditLogService.createAuditLog(new AuditLog("DELETE_BENEFICIARY", "admin", "Deleted beneficiary with ID: " + id));
            return true;
        }
        return false;
    }
}
