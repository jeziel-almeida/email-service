package com.challenge.emailservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.emailservice.application.EmailSenderService;
import com.challenge.emailservice.core.EmailRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    
    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String sendEmail(@RequestBody @Valid EmailRequest request) {
        this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
        return "Email sent successfully";
    }
}
