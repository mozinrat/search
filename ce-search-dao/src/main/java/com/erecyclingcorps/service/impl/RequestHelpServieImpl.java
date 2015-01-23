/*
 * ApiServieImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.RequestHelpDAO;
import com.erecyclingcorps.dto.ContactUsDTO;
import com.erecyclingcorps.enums.LabelConstant;
import com.erecyclingcorps.service.LabelConstantService;
import com.erecyclingcorps.service.RequestHelpService;

@Service
public class RequestHelpServieImpl implements RequestHelpService {

    @Autowired
    RequestHelpDAO requestHelpDAO;
    
    @Resource
    LabelConstantService labelConstantService;
    
    @Override
    @Cacheable(value="contactusemail",key="'cesearch.getContactUsEmail-'+#program")
    public ContactUsDTO getContactUsEmailWidgets(String program) {
        ContactUsDTO response = requestHelpDAO.getContactUsEmailWidgets(program);
        response.setButton(labelConstantService.findLabelConstantByCode(LabelConstant.SUBMIT_BUTTON.toString()));
        return response;

    }
}
