package com.challenge.emailservice.application;

import org.springframework.stereotype.Service;

import com.challenge.emailservice.adapters.EmailSenderGateway;
import com.challenge.emailservice.core.cases.EmailSenderUseCase;
import com.challenge.emailservice.core.exceptions.EmailServiceException;
import com.challenge.emailservice.infra.sendgrid.SendgridEmailSender;
import com.challenge.emailservice.infra.ses.SesEmailSender;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway sesEmailSender;
    private final EmailSenderGateway sendgridEmailSender;

    public EmailSenderService(SesEmailSender sesEmailSender, SendgridEmailSender sendgridEmailSender) {
        this.sesEmailSender = sesEmailSender;
        this.sendgridEmailSender = sendgridEmailSender;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body) {
        try {

            this.sesEmailSender.sendEmail(to, subject, body);
            
        } catch(EmailServiceException e) {       
            try {

                this.sendgridEmailSender.sendEmail(to, subject, body);

            } catch(EmailServiceException e2) {
                throw e2;
            }
        }
    }
    
}
