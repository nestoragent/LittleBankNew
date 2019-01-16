package com.littlebank.littlebanknew.repository;

import com.littlebank.littlebanknew.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;


//@Component
//@org.springframework.stereotype.Repository("BankAccountRepository")
//public class BankAccountRepositoryImpl implements BankAccountRepository {
//
//    private final BankAccountRepository repository;
//
//    @Autowired
//    public BankAccountRepositoryImpl(BankAccountRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... strings) {
//        this.repository.save(new BankAccount(UUID.randomUUID(), 3442334L, "asd", "Test name", 23423L));
//        this.repository.save(new BankAccount(UUID.randomUUID(), 342423L, "asd", "Test name2", 123434L));
//    }
//}
