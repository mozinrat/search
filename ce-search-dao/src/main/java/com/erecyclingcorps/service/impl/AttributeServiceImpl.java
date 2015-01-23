/*
 * AttributeServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.AttributeDAO;
import com.erecyclingcorps.dto.AttributeDTO;
import com.erecyclingcorps.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private AttributeDAO attributeDAO;

	@Override
	@Cacheable(value="findbyattribute",key="'cesearch.findAttributeNameByMetaData-'+#attribute+'-'+#program+'-'+#prioritizationCategory")
	public List<String> findAttributeNameByMetaData(Long attribute, Long program, String prioritizationCategory) {
		return attributeDAO.findAllByAttribute(attribute, program, prioritizationCategory);
	}

	@Cacheable(value="findAttributeByProgram",key="'cesearch.findAllAttributeByProgram-'+#programId")
	public List<? extends AttributeDTO> findAllAttributeByProgram(Long programId) {
		return attributeDAO.findAllAttributeByProgram(programId);
	}

	@Override
	public String findDescriptionByPK(Long attributeId) {
		return attributeDAO.findByPK(attributeId).getDescription();
	}

	@Cacheable(value="findbyattribute2",key="'cesearch.findAttributeNameByMetaData2-'+#attribute+'-'+#program+'-'+#prioritizationCategory")
    public Set<String> findAttributeNameByMetaData(Long attribute, Long program, Set<String> categories) {
        return new HashSet<String>(attributeDAO.findAllByAttribute(attribute, program,categories));
    }
}
