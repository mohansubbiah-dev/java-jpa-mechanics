package com.example.hibernateqa.service;

import com.example.hibernateqa.entity.Account;
import com.example.hibernateqa.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LockingService {

    private final AccountRepository accountRepository;

    public LockingService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account deposit(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id).orElseThrow();
        account.setBalance(account.getBalance().add(amount));
        return account;
    }
}
