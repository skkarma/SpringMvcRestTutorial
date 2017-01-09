package com.spring.SpringMvcRestTutorial.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringMvcRestTutorial.mail.MailSender;

/**
 * Created by Sachin.Karma on 1/3/2017.
 */
@RestController
public class RootController {


    private MailSender mailSender;

   @Autowired
    public RootController(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping("/sendMail")
    public String mailSend() throws MessagingException {
        mailSender.send("sachin.karma@infobeans.com","Hello", "Test Message");
        return "Mail Sent";
    }
}
