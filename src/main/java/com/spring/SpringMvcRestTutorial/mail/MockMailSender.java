package com.spring.SpringMvcRestTutorial.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sachin.Karma on 1/3/2017.
 */
public class MockMailSender implements MailSender {

    private static final Log log= LogFactory.getLog(MockMailSender.class);

    @Override
    public void send(String to, String subject, String msg) {
        log.info("Sending Mock Mail to " + to);
        log.info("Subject " + subject);
        log.info("Body " + msg);
    }
}
