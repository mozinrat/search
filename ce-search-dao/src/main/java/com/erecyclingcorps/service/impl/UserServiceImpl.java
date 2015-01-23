/*
 * UserServiceImpl.java 4:14:00 PM Dec 2, 2014
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.domain.User;
import com.erecyclingcorps.dto.ProgramDTO;
import com.erecyclingcorps.service.AttributeService;
import com.erecyclingcorps.service.ProgramService;
import com.erecyclingcorps.service.UserService;
import com.erecyclingcorps.utils.Constants;

/**
 * @author parora
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private ProgramService programService;
	@Autowired
	private AttributeService attributeService;

	@Override
	public Map<String, Object> getCurrentUserProgramList() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ProgramDTO program = programService.findCurrentUserProgram(user.getUsername());
		if ((Constants.ALL).equalsIgnoreCase(program.getProgramName())) {
			map.put(Constants.PROGRAM_LIST, programService.getAllPrograms());
		}
		return map;
	}

	@Override
	public Map<String, Object> getUserProgramDataOnLoad() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ProgramDTO program = programService.findCurrentUserProgram(user.getUsername());
		if ((Constants.ALL).equalsIgnoreCase(program.getProgramName())) {
			map.put(Constants.PROGRAM_LIST, programService.getAllPrograms());
		} else {
			map.put(Constants.PROGRAM_VALUE, program.getId());
			map.put(Constants.ATTRIBUTE_LIST, attributeService.findAllAttributeByProgram(program.getId()));
		}
		return map;
	}


}
