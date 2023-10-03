package com.challenge.emailservice.application;

import org.springframework.stereotype.Service;

import com.challenge.emailservice.adapters.EmailSenderGateway;
import com.challenge.emailservice.core.cases.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
    
}
