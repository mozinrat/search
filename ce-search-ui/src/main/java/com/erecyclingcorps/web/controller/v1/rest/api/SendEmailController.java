package com.erecyclingcorps.web.controller.v1.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erecyclingcorps.dto.EmailDetailDTO;
import com.erecyclingcorps.service.EmailFacade;

@Controller
@RequestMapping("/api/sendEmail")
public class SendEmailController {

    @Autowired 
    private EmailFacade sendEmailService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> doSendEmail(@RequestBody EmailDetailDTO emailContent) {
        sendEmailService.doSendEmail(emailContent);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);  
    }
}