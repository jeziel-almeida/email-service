package com.challenge.emailservice.core.cases;

public interface EmailSenderUseCase {
    
    void sendEmail(String to, String subject, String body);
}
