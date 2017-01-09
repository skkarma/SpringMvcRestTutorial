package com.spring.SpringMvcRestTutorial.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by Sachin.Karma on 1/4/2017.
 */
public class SmtpAuthenticator extends Authenticator{

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,password);
    }
}
