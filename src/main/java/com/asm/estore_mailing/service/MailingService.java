package com.asm.estore_mailing.service;

import com.asm.estore_mailing.entity.EmailModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailingService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailModel emailModel) {
        emailModel.setSent(LocalDateTime.now());
        try {
            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom(emailModel.getFrom());
            smm.setTo(emailModel.getTo());
            smm.setSubject(emailModel.getSubject());
            smm.setText(emailModel.getText());

            emailSender.send(smm);

        } catch (MailException e) {
            System.out.println(e.getMessage());
        }
    }
}
