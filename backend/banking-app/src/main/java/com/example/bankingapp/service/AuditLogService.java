package com.example.bankingapp.service;

import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public List<AuditLog> getAllAuditLogs() {
        return auditLogRepository.findAll();
    }

    public AuditLog createAuditLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }
}
