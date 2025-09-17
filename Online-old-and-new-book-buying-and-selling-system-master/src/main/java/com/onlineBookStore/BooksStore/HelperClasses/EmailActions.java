package com.onlineBookStore.BooksStore.HelperClasses;

import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.onlineBookStore.BooksStore.Entities.User;

public class EmailActions {

    // Verification Email
    static public boolean sendVerificationMail(User u, String verificationCode, JavaMailSender emailSender) {
        boolean flag = false;
        try {
            String subject = "Please verify your registration";
            String senderName = "Book Shop Team";
            String mailContent = "<p>Dear " + u.getUserName() + ", </p>";
            mailContent += "<p>Please click the link below to verify your registration:</p>";
            String verifyUrl = "http://localhost:9090/verify?code=" + verificationCode;
            mailContent += "<h3><a href=\"" + verifyUrl + "\">Verify</a></h3>";
            mailContent += "<p>Thank you<br>Book Shop Team</p>";

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("bookstoreapplication1234@gmail.com", senderName);  // ✅ fix
            helper.setTo(u.getUserEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true);

            emailSender.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Store Activation Email
    static public boolean sendActiveStoreMessage(User u, JavaMailSender emailSender) {
        boolean flag = false;
        try {
            String subject = "Your book store is now activated!!";
            String senderName = "Book Shop Team";
            String mailContent = "<p>Dear " + u.getUserName() + ", </p>";
            mailContent += "<p>Your registered book store is now active. You can now publish books publicly.</p>";
            mailContent += "<p>Thank you <br>Book Shop Team</p>";

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("bookstoreapplication1234@gmail.com", senderName);  // ✅ fix
            helper.setTo(u.getUserEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true);

            emailSender.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Reset Password Email ✅ (was incomplete in your file)
    static public boolean sendResetPasswordEmailMessage(User u, String verificationCode, JavaMailSender emailSender) {
        boolean flag = false;
        try {
            String subject = "Reset your password";
            String senderName = "Book Shop Team";
            String mailContent = "<p>Dear " + u.getUserName() + ", </p>";
            mailContent += "<p>Please click the link below to reset your password:</p>";
            String resetUrl = "http://localhost:9090/reset_password?code=" + verificationCode;
            mailContent += "<h3><a href=\"" + resetUrl + "\">Reset Password</a></h3>";
            mailContent += "<p>If you did not request a password reset, please ignore this email.</p>";
            mailContent += "<p>Thank you <br>Book Shop Team</p>";

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("bookstoreapplication1234@gmail.com", senderName);  // ✅ fix
            helper.setTo(u.getUserEmail());
            helper.setSubject(subject);
            helper.setText(mailContent, true);

            emailSender.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

