package com.littlebank.littlebanknew.service;

import java.util.Map;

public interface BankAccountService {
    Map<String, Object> save(String accountNumber, String IBAN, String bankName, String bic);
}
