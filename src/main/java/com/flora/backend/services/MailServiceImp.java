package com.flora.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImp implements MailService{
    private final JavaMailSender javaMailSender;


    public void sendPasswordResetEmail(String email, String resetToken) {
        String subject = "Password Reset Request";
        String resetLink = "http://localhost:8080/auth/validate-token?token=" + resetToken;
        String message = "Hello,\n\n"
                + "You have requested to reset your password. Click the link below to reset your password:\n\n"
                + resetLink + "\n\n"
                + "If you didn't request this, please ignore this email.\n\n"
                + "Best regards,\n"
                + "Flora";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
