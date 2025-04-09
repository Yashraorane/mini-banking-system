package com.example.bankingapp.controller;

import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    // Get all audit logs (Admin only)
    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllAuditLogs() {
        return ResponseEntity.ok(auditLogService.getAllAuditLogs());
    }
}
