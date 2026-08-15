package com.example.hibernateqa.controller;

import com.example.hibernateqa.entity.Account;
import com.example.hibernateqa.service.LockingService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/hibernate/locking")
public class LockingController {

    private final LockingService lockingService;

    public LockingController(LockingService lockingService) {
        this.lockingService = lockingService;
    }

    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return lockingService.deposit(id, amount);
    }
}
