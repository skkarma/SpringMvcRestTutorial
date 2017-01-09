package com.spring.SpringMvcRestTutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Sachin.Karma on 1/3/2017.
 */
public class SmtpMailSender implements MailSender {

    private static final Log log= LogFactory.getLog(SmtpMailSender.class);

    private JavaMailSender javaMailSender;

    public void setJavaMailSender(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

   @Override
    public void send(String to, String subject, String msg) throws MessagingException {
        log.info("Sending SMTP Mail to" + to);
        /*log.info("Subject " + subject);
        log.info("Body " + msg);
*/
       MimeMessage message = javaMailSender.createMimeMessage();
       MimeMessageHelper helper;
       helper = new MimeMessageHelper(message, true); // true indicates
       // multipart message
       helper.setSubject(subject);
       helper.setTo(to);
       helper.setText(msg, true); // true indicates html
       // continue using helper for more functionalities
       // like adding attachments, etc.
       javaMailSender.send(message);
    }
}