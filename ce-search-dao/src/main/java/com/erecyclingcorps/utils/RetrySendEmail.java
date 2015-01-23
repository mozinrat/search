package com.erecyclingcorps.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.erecyclingcorps.dto.EmailDetailDTO;
import com.erecyclingcorps.service.EmailFacade;

@Component
public class RetrySendEmail {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetrySendEmail.class);

    @Autowired 
    private EmailFacade sendEmailService;

    @Scheduled(fixedRate = 8640000)
    public void retryEmailSending() {
        List<EmailDetailDTO> emails = sendEmailService.getRetryEmails(Constants.PROGRAM_ATT);
        for(EmailDetailDTO email:emails){
            LOGGER.info("Resending email with id :"+email.getId());
            sendEmailService.retryEmailSending(email);
        }        
    }
}
