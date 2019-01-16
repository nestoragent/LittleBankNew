package com.littlebank.littlebanknew.service;


import com.littlebank.littlebanknew.entity.BankAccount;
import com.littlebank.littlebanknew.repository.BankAccountRepository;
import com.littlebank.littlebanknew.utils.Ajax;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("BankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public Map<String, Object> save(String accountNumber, String IBAN, String bankName, String bic) {
        try {
            BankAccount account = new BankAccount(IBAN, bankName);

            log.info("data: " + accountNumber + " " + IBAN + " " + bankName + " " + bic);

            try {
                account.setAccountNumber(Long.parseLong(accountNumber));
            } catch (NumberFormatException e) {
                log.error("Cant convert accountNumber value: " + accountNumber + " to Long type.", e);
                return Ajax.errorResponse("Cant convert accountNumber value: " + accountNumber + " to Long type.");
            }
            try {
                account.setBic(Long.parseLong(bic));
            } catch (NumberFormatException e) {
                log.error("Cant convert bic value: " + bic + " to Long type.", e);
                return Ajax.errorResponse("Cant convert bic value: " + bic + " to Long type.");
            }
            //TODO need to add the check for already exist accountNumber
            bankAccountRepository.save(account);
            return Ajax.successResponse(account);
        } catch (Exception e) {
            log.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return Ajax.errorResponse("ERROR SAVING DATA: " + e.getMessage());
        }
    }
}