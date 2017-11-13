package com.ikuwow.selfstudyspring.aspect;

import com.ikuwow.selfstudyspring.model.Memo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public String handleException(MemoException e) {
        LOGGER.error("MemoException", e);
        return "Error!!";
    }

    @InitBinder
    public void initBinder(WebDataBinder biner) {
        LOGGER.info("InitBinder");
    }

    @ModelAttribute
    public void modelAttribute(Memo model) {
        LOGGER.info("ModelAttribute");
    }

    public static class MemoException extends RuntimeException {}

}
