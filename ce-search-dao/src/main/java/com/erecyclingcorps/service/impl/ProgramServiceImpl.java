/*
 * ProgramServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.ProgramDAO;
import com.erecyclingcorps.dto.ProgramDTO;
import com.erecyclingcorps.service.ProgramService;
@Service
public class ProgramServiceImpl implements ProgramService {
	@Autowired
	private ProgramDAO programDAO;

	@Override
	@Cacheable(value="getAllProgram",key="'cesearch.getAllProgram'")
	public List<? extends ProgramDTO> getAllPrograms() {
		return programDAO.findAll();
	}

	@Override
	@Cacheable(value="currentUserProgram",key="'cesearch.findUser'+#username")
	public ProgramDTO findCurrentUserProgram(String username) {
		return programDAO.findCurrentUserProgram(username);
	}

}
