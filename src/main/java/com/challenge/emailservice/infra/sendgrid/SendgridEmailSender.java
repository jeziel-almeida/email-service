package com.challenge.emailservice.infra.sendgrid;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.challenge.emailservice.adapters.EmailSenderGateway;
import com.challenge.emailservice.core.exceptions.EmailServiceException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendgridEmailSender implements EmailSenderGateway {

    public SendgridEmailSender() {
        
    }

    @Override
    public void sendEmail(String to, String subject, String body) throws EmailServiceException {
        
        Email from = new Email("jeziel.almeida16@gmail.com");
        String email_subject = subject;
        Email email_to = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, email_subject, email_to, content);

        try {
        
            SendGrid sg = new SendGrid("SENDGRID_API_KEY");
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            if (response.getStatusCode() != 202) throw new EmailServiceException("Request not accepted");
            
        } catch(IOException ex ) {
            throw new EmailServiceException("Failure while sending email with SendGrid");
        }
    }
    
}
