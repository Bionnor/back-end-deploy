package com.flora.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


public interface MailService {
    public void sendPasswordResetEmail(String email, String resetToken);
}
