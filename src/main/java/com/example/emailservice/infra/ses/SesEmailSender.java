package com.example.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.example.emailservice.adpters.EmailSenderGateway;
import com.example.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {


    private final AmazonSimpleEmailService emailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("rayansf18@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            this.emailService.sendEmail(request);
        } catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }
}
