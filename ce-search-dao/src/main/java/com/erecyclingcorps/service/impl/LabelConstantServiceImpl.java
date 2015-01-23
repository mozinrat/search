/*
 * LabelConstantServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.LabelConstantDAO;
import com.erecyclingcorps.service.LabelConstantService;
@Service("labelConstantService")
public class LabelConstantServiceImpl  implements LabelConstantService {

    @Autowired
    LabelConstantDAO labelConstantDAO;

    @Override
    @Cacheable(value="findLabelConstantByCode",key="'cesearch.findLabelConstantByCode-'+#code")
    public String findLabelConstantByCode(String code) {
        return labelConstantDAO.findLabelConstantByCode(code);

    }

}
