package com.erecyclingcorps.service;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.ContactUsDTO;

@Transactional(readOnly = true)
public interface RequestHelpService {

    public ContactUsDTO getContactUsEmailWidgets(String program) ;
}
