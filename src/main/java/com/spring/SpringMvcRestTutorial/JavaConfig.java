package com.spring.SpringMvcRestTutorial;

import com.spring.SpringMvcRestTutorial.mail.MailSender;
import com.spring.SpringMvcRestTutorial.mail.MockMailSender;
import com.spring.SpringMvcRestTutorial.mail.SmtpAuthenticator;
import com.spring.SpringMvcRestTutorial.mail.SmtpMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.mail.Authenticator;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by Sachin.Karma on 1/3/2017.
 */
@Configuration
public class JavaConfig {

    @Value("${spring.mail.host}")
    private String host;
    @Value("${smtp.authenticator.email}")
    private String username;
    @Value("${smtp.authenticator.password}")
    private String password;

    @Bean
    @Profile("dev")
    public MailSender mockMailSender(){
        return new MockMailSender();
    }

    @Bean
    @Profile("!dev")
    public MailSender smtpMailSender(JavaMailSender javaMailSender) {
        SmtpMailSender mailSender = new SmtpMailSender();
        mailSender.setJavaMailSender(getJavaMailSender());
        return mailSender;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setSession(getMailSession());
        return sender;
    }

    private Session getMailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", false);
        return Session.getInstance(props, getAuthenticator());
    }

    private Authenticator getAuthenticator() {
        SmtpAuthenticator authenticator = new SmtpAuthenticator();
        authenticator.setUsername(username);
        authenticator.setPassword(password);
        return authenticator;
    }
}
