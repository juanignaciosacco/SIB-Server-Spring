package com.juanignacio.sibServer.services.impl;

import com.juanignacio.sibServer.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class SinSockImpl extends EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String mensaje) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email);
            helper.setTo("juanchisacco@gmail.com");
            helper.setSubject("Producto sin stock SIB Shop");
            helper.setText(mensaje, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
