package com.example.emailservice.application;

import com.example.emailservice.adpters.EmailSenderGateway;
import com.example.emailservice.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUserCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {

        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void senderEmail(String to, String subject, String body) {

        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
