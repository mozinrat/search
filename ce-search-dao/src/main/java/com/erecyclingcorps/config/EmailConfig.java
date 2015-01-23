package com.erecyclingcorps.config;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "com.erecyclingcorps.*")
@PropertySource("classpath:jdbc.properties")
public class EmailConfig {

    @Autowired
    private org.springframework.core.env.Environment env;

    @Bean
    public JavaMailSender javaMailService() {
        String host = env.getProperty("email.host");
        String port = env.getProperty("email.port");
        String username = env.getProperty("email.username");
        String password = env.getProperty("email.password");
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(Integer.parseInt(port));
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setJavaMailProperties(getMailProperties());
        return javaMailSender;
    }

    private Properties getMailProperties() {
        String smtpAuth = env.getProperty("email.auth");
        String protocol = env.getProperty("email.protocol");
        String starttls = env.getProperty("email.starttls");
        String maildebug = env.getProperty("email.maildebug");
        String timeout = env.getProperty("email.timeout");
        String socketFactoryport = env.getProperty("email.socketFactoryport");
        String socketFactoryclass = env.getProperty("email.socketFactoryclass");
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", protocol);
        properties.setProperty("mail.smtp.auth", smtpAuth);
        properties.setProperty("mail.smtp.starttls.enable", starttls);
        properties.setProperty("mail.debug", maildebug);
        properties.put("mail.smtp.timeout", timeout);
        if(StringUtils.isBlank(socketFactoryport)){
            properties.put("mail.smtp.socketFactory.port", socketFactoryport);
        }
        if(StringUtils.isBlank(socketFactoryclass)){
            properties.put("mail.smtp.socketFactory.class", socketFactoryclass);
        }
        return properties;
    }

}
