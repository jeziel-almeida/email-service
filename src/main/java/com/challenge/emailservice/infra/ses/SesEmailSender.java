package com.challenge.emailservice.infra.ses;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.challenge.emailservice.adapters.EmailSenderGateway;
import com.challenge.emailservice.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService sesClient;

    public SesEmailSender(AmazonSimpleEmailService sesClient) {
        this.sesClient = sesClient;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
            .withSource("jeziel.almeida16@gmail.com")
            .withDestination(new Destination().withToAddresses(to))
            .withMessage(new Message()
                .withSubject(new Content(subject))
                .withBody(new Body().withText(new Content(body)))
            );

        try {
            sesClient.sendEmail(request);

        } catch (AmazonServiceException ex) {
            throw new EmailServiceException("Failure while sending email with AmazonSES", ex);
        } catch (SdkClientException ex) {
            throw new EmailServiceException("Failure to execute HTTP request", ex);
        }
    }
    
}
