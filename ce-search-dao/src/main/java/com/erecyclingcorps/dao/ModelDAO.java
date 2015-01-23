/*
 * ModelDAO.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.domain.ModelAttachment;
import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;

/**
 * @author parora
 **/

@Repository
public interface ModelDAO {

	/* 
	 * Returns ModelAttachment objects input manufacturerModelId
	 * @see com.erecyclingcorps.dto.AttachmentType
	*/
	public ModelAttachment getModelAttachment(Long manufacturerModelId,AttachmentType type);
	
	/* 
	 * Returns Models from database depends upon searchText and filters
	 * @see com.erecyclingcorps.dto.ModelDTO  
	*/
	public List<ModelDTO> findModel(ModelSearchDTO modelSearchDTO);
	
	/*
	 *  Returns List of Top Models from database depends upon ranking for a specific program
	 *  @see com.erecyclingcorps.dto.ModelDTO
	*/
	public List<ModelDTO> findTopRatedModel(String program);

}
