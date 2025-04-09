package com.example.bankingapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bankingapp.model.AuditLog;

public interface AuditLogRepository extends MongoRepository<AuditLog, String> {
}
