package com.example.emailservice.core;

public interface EmailSenderUserCase {

    void senderEmail(String to, String subject, String body);
}
