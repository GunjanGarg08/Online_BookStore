package com.onlineBookStore.BooksStore.HelperClasses;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.onlineBookStore.BooksStore.Entities.User;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean sendVerificationMail(User u, String code) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            String subject = "Please verify your registration";
            String senderName = "Book Store Team";
            String mailContent = "<p>Dear " + u.getUserName() + ",</p>"
                    + "<p>Please verify using this code: <b>" + code + "</b></p>";
            helper.setFrom("bookstoreapplication1234@gmail.com", senderName);
            helper.setTo(u.getUserEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true);
            mailSender.send(message);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
