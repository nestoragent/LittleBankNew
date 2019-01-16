package com.littlebank.littlebanknew.repository;

import com.littlebank.littlebanknew.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
