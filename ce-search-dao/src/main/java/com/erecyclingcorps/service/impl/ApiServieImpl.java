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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.ProgramGeneralAttributesDAO;
import com.erecyclingcorps.service.ApiService;
import com.erecyclingcorps.utils.Constants;
import com.erecyclingcorps.utils.Constants.AttributeCode;

@Service
public class ApiServieImpl implements ApiService {

    @Autowired
    private ProgramGeneralAttributesDAO programAttributesDAO;

    /**
     * Method used to get CE_APP DATA to make rest request to ce-app for model search.
     */
    @Override
    public Map<String, String> getAPIData(String program) {
        Map<String, String> apiData = programAttributesDAO.getAPIData(program);
        Map<String, String> apiDataTransformed = new HashMap<String, String>(2);
        apiDataTransformed.put(Constants.URL, apiData.get(AttributeCode.CE_APP_URL.getCode()));
        String userCredentials = apiData.get(AttributeCode.CE_APP_USERNAME.getCode()) + ":" + apiData.get(AttributeCode.CE_APP_PASSWORD.getCode());
        String token = new String(Base64.encodeBase64(userCredentials.getBytes()));
        apiDataTransformed.put(Constants.TOKEN, token);
        return apiDataTransformed;
    }
    @Override
    @Cacheable(value="bannerdata",key="'cesearch.getBannerData-'+#program")
    public Map<String, String> getBannerData(String program) {
        return programAttributesDAO.getBannerData(program);
    }

}
