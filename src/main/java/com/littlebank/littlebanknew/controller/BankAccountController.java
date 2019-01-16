package com.littlebank.littlebanknew.controller;

import com.littlebank.littlebanknew.service.BankAccountService;
import com.littlebank.littlebanknew.utils.Ajax;
import com.littlebank.littlebanknew.utils.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@Controller
@Slf4j
public class BankAccountController {

    private static final String VIEW_INDEX = "index.js";
    @Autowired
    @Qualifier("BankAccountService")
    private BankAccountService bankAccountService;

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    Map<String, Object> create(@Valid @RequestParam String accountNumber,
                               @Valid @RequestParam String IBAN,
                               @Valid @RequestParam String bankName,
                               @Valid @RequestParam String bic) throws RestException {
        try {

            if (accountNumber == null || accountNumber.equals("")) {
                return Ajax.emptyResponse();
            }
            return bankAccountService.save(accountNumber, IBAN, bankName, bic);
        } catch (Exception e) {
            log.error("Exception in the create", e);
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String index() throws RestException {

        return VIEW_INDEX;
    }

//    @RequestMapping(value = "/getRandomData", method = RequestMethod.GET)
//    public @ResponseBody
//    Map<String, Object> getRandomData() throws RestException {
//        try {
//            Set<String> result = bankAccountService.getRandomData();
//            return Ajax.successResponse(result);
//        } catch (Exception e) {
//            throw new RestException(e);
//        }
//    }
}
