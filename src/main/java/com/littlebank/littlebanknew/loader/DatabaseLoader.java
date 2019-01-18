package com.littlebank.littlebanknew.loader;

import com.littlebank.littlebanknew.entity.BankAccount;
import com.littlebank.littlebanknew.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final BankAccountRepository repository;

    @Autowired
    public DatabaseLoader(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new BankAccount(1111L, "Baggins", "ring bearer", 1111L));
    }
}
