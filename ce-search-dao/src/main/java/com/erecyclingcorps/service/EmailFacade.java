package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dto.EmailDetailDTO;
import com.erecyclingcorps.enums.LabelConstant;
import com.erecyclingcorps.utils.Constants;

@Service 
public class EmailFacade {
    
    @Autowired 
    private SendEmailService sendEmailService;

    @Autowired
    private LabelConstantService labelConstantService;
    
    @Async(value="asyncExecutor")
    public void doSendEmail(EmailDetailDTO emailContent) {
   	 if(labelConstantService.findLabelConstantByCode(LabelConstant.SEND_EMAIL.toString()).equalsIgnoreCase(Constants.STRING_BOOLEAN_TRUE)){
         sendEmailService.doSendEmail(emailContent);
   	 }
    }
    
    @Async(value="asyncExecutor")
    public void retryEmailSending(EmailDetailDTO emailContent){
   	 if(labelConstantService.findLabelConstantByCode(LabelConstant.SEND_EMAIL.toString()).equalsIgnoreCase(Constants.STRING_BOOLEAN_TRUE)){
        sendEmailService.retryEmailSending(emailContent);
   	 }
    }

    public List<EmailDetailDTO> getRetryEmails(String program) {
        return sendEmailService.getRetryEmails(program);
    }
     
}
