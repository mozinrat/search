package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.EmailDetailDTO;

@Transactional(readOnly=true)
public interface SendEmailService {

    @Transactional(readOnly=false)
    public void doSendEmail(EmailDetailDTO emailcontent);
    
    @Transactional(readOnly=false)
    public void retryEmailSending(EmailDetailDTO emailContent) ;

    public List<EmailDetailDTO> getRetryEmails(String program);

}
