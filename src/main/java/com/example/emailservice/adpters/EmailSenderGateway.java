package com.example.emailservice.adpters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
