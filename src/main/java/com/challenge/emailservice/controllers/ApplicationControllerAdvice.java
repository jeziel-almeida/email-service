package com.challenge.emailservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.emailservice.core.exceptions.EmailServiceException;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    
    @ExceptionHandler(EmailServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleEmailServiceException(EmailServiceException ex) {
        return ex.getMessage();
    }
}
