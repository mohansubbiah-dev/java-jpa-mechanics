package com.example.hibernateqa.repository;

import com.example.hibernateqa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
