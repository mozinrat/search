/*
 * SendEmailService.java 4:14:00 PM Dec 29, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.SendEmailDAO;
import com.erecyclingcorps.dto.EmailDetailDTO;
import com.erecyclingcorps.service.SendEmailService;
import com.erecyclingcorps.utils.Constants;

@Service
public class SendEmailServieImpl implements SendEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailServieImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    SendEmailDAO sendEmailDAO;

    @Override
    public void doSendEmail(EmailDetailDTO emailContent) {
        String status;
        try {
            status = sendEmail(emailContent).get();
        } catch (InterruptedException | ExecutionException e) {
            status=Constants.RETRY;
            LOGGER.error(e.getMessage(),e); 
        }
        sendEmailDAO.persistEmail(emailContent,status);
    }

    public void retryEmailSending(EmailDetailDTO emailContent) {
        try {
            String status = sendEmail(emailContent).get();
            sendEmailDAO.persistRetriedEmail(emailContent, status);
        } catch (InterruptedException | ExecutionException e) {
            // No handling required when retrying, the email will simply retried in next schedule
            LOGGER.error(e.getMessage(),e); 
        }

    }


    @Override
    public List<EmailDetailDTO> getRetryEmails(String program) {
        return sendEmailDAO.getRetryEmails(program);
    }

    private Future<String> sendEmail(EmailDetailDTO emailcontent) {
        String status = "";
        try{
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(emailcontent.getRecipientAddress());
            email.setSubject(emailcontent.getSubject());
            email.setText(emailcontent.getMessage());
            email.setFrom(emailcontent.getSenderAddress());
            email.setSentDate(new Date());
            mailSender.send(email);
            status=Constants.SUCCESS;
        }catch(MailAuthenticationException ex){
            status=Constants.FAILURE;
            LOGGER.error(ex.getMessage(),ex); 
        }catch(MailException retry){
            status=Constants.RETRY;
            LOGGER.error(retry.getMessage(),retry); 
        }
        return new AsyncResult<String>(status);
    }
}

