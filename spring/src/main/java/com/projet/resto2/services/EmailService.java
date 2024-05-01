//package com.projet.resto2.services;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import jakarta.mail.*;
//import jakarta.mail.internet.*;
//import java.util.Properties;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender emailSender;
//
//    public String getEmailContent() {
//        try {
//            Store store = emailSender.getSession().getStore("imaps");
//            store.connect("your_email_host", "your_email_username", "your_email_password");
//
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//
//            Message[] messages = inbox.getMessages();
//            StringBuilder content = new StringBuilder();
//
//            for (Message message : messages) {
//                content.append(message.getSubject()).append(": ");
//                content.append(message.getContent()).append("\n");
//            }
//
//            inbox.close(false);
//            store.close();
//
//            return content.toString();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return "Error fetching email content.";
//        }
//    }
//}
