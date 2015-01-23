package com.erecyclingcorps.dao;

import java.util.List;

import com.erecyclingcorps.dto.EmailDetailDTO;


public interface SendEmailDAO {
    
    public void persistEmail(EmailDetailDTO emailcontent,String status);

    void persistRetriedEmail(EmailDetailDTO emailcontent, String status);

    public List<EmailDetailDTO> getRetryEmails(String program);
}
