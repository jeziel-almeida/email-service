package com.challenge.emailservice.application;

import org.springframework.stereotype.Service;

import com.challenge.emailservice.adapters.EmailSenderGateway;
import com.challenge.emailservice.core.cases.EmailSenderUseCase;
import com.challenge.emailservice.core.exceptions.EmailServiceException;
import com.challenge.emailservice.infra.sendgrid.SendgridEmailSender;
import com.challenge.emailservice.infra.ses.SesEmailSender;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway1;
    private final EmailSenderGateway emailSenderGateway2;

    public EmailSenderService(SesEmailSender sesEmailSender, SendgridEmailSender sendgridEmailSender) {
        this.emailSenderGateway1 = sesEmailSender;
        this.emailSenderGateway2 = sendgridEmailSender;
    }
    
    @Override
    public void sendEmail(String to, String subject, String body) {
        try {
            this.emailSenderGateway1.sendEmail(to, subject, body);

        } catch(EmailServiceException e) {       
            try {
                this.emailSenderGateway2.sendEmail(to, subject, body);

            } catch(EmailServiceException e2) {
                throw e2;
            }
        }
    }
    
}
