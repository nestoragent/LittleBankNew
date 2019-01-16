package com.littlebank.littlebanknew.controller;

import com.littlebank.littlebanknew.utils.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(RestException.class)
    public @ResponseBody
    String handleException(RestException e) {
        log.error("Ошибка: " + e.getMessage(), e);
        return "Ошибка: " + e.getMessage();
    }
}
