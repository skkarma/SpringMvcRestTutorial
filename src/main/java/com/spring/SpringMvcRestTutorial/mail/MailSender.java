package com.spring.SpringMvcRestTutorial.mail;

import javax.mail.MessagingException;

/**
 * Created by Sachin.Karma on 1/3/2017.
 */
public interface MailSender {

    void send(String to,String subject, String msg) throws MessagingException;;
}
