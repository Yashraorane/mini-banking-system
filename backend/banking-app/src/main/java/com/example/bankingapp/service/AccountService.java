package com.example.bankingapp.service;

import com.example.bankingapp.model.Account;
import com.example.bankingapp.model.AuditLog;
import com.example.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuditLogService auditLogService;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        Account createdAccount = accountRepository.save(account);
        auditLogService.createAuditLog(new AuditLog("CREATE_ACCOUNT", "admin", "Created account with number: " + createdAccount.getAccountNumber()));
        return createdAccount;
    }

    public Optional<Account> updateAccount(String id, Account accountDetails) {
        return accountRepository.findById(id).map(account -> {
            account.setAccountNumber(accountDetails.getAccountNumber());
            account.setBalance(accountDetails.getBalance());
            account.setType(accountDetails.getType());
            account.setUserId(accountDetails.getUserId());
            account.setBranch(accountDetails.getBranch());
            return accountRepository.save(account);
        });
    }

    public boolean deleteAccount(String id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            auditLogService.createAuditLog(new AuditLog("DELETE_ACCOUNT", "admin", "Deleted account with ID: " + id));
            return true;
        }
        return false;
    }
}
