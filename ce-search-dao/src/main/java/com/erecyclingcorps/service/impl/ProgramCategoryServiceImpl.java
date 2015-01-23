/*
 * ProgramCategoryServiceImpl.java 4:14:00 PM Dec 2, 2014
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

import com.erecyclingcorps.dao.ProgramCategoryDAO;
import com.erecyclingcorps.dao.domain.ProgramCategory;
import com.erecyclingcorps.service.ProgramCategoryService;

@Service
public class ProgramCategoryServiceImpl implements ProgramCategoryService {
	@Autowired
	private ProgramCategoryDAO programCategoryDAO;

	@Cacheable(value="findByProgramCategory",key="'cesearch.findByProgramCategory-'+#programId+'-'+#prioritizationCategory")
	@Override
	public ProgramCategory findByProgramCategory(Long programId, String prioritizationCategory) {
		return programCategoryDAO.findByProgramCategory(programId, prioritizationCategory);
	}

}
