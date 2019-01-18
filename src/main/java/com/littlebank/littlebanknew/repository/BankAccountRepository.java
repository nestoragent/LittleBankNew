package com.littlebank.littlebanknew.repository;

import com.littlebank.littlebanknew.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
