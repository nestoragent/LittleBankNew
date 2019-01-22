package com.littlebank.littlebanknew.repository;

import com.littlebank.littlebanknew.entity.BankAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankAccountRepository extends PagingAndSortingRepository<BankAccount, Long> {
}
