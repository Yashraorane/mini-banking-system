package com.example.bankingapp.service;

import com.example.bankingapp.model.Branch;
import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private AuditLogService auditLogService;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Optional<Branch> getBranchByBranchCode(String branchCode) {
        return branchRepository.findByBranchCode(branchCode);
    }

    public Branch createBranch(Branch branch) {
        Branch createdBranch = branchRepository.save(branch);
        auditLogService.createAuditLog(new AuditLog("CREATE_BRANCH", "admin", "Created branch with code: " + createdBranch.getBranchCode()));
        return createdBranch;
    }

    public boolean deleteBranch(String id) {
        if (branchRepository.existsById(id)) {
            branchRepository.deleteById(id);
            auditLogService.createAuditLog(new AuditLog("DELETE_BRANCH", "admin", "Deleted branch with ID: " + id));
            return true;
        }
        return false;
    }
}
