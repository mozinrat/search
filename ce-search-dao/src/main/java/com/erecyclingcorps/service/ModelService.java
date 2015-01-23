/*
 * ModelService.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;
import com.erecyclingcorps.exceptions.ModelImageNotFoundException;

/**
 * @author parora
 **/

@Transactional(readOnly = true)
public interface ModelService {

	/* 
	 * Returns Models depends upon searchText and filters  
	*/
	public List<ModelDTO> findModel(ModelSearchDTO modelSearchDTO);

	/* 
	 * Returns binary for image otherwise throws ModelImageNotFoundException
	*/
	public byte[] getModelAttachment(Long manufacturerModelId, AttachmentType type) throws ModelImageNotFoundException;

	/*
	 *  Returns List of Top Models depends upon ranking
	*/
	public List<ModelDTO> findTopRatedModel(String program);

}
