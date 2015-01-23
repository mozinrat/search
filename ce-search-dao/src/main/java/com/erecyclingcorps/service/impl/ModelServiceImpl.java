/*
 * ModelServiceImpl.java 4:14:00 PM Dec 2, 2014
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
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.ModelDAO;
import com.erecyclingcorps.dao.domain.ModelAttachment;
import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;
import com.erecyclingcorps.exceptions.ModelImageNotFoundException;
import com.erecyclingcorps.service.ModelService;

/**
 * @author parora
 **/

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelDAO modelDao;

	@Override
	public List<ModelDTO> findModel(ModelSearchDTO modelSearchDTO) {
		return modelDao.findModel(modelSearchDTO);
	}

	public byte[] getModelAttachment(Long manufacturerModelId, AttachmentType type) throws ModelImageNotFoundException {
		byte[] data = null;
		ModelAttachment modelAttachment = modelDao.getModelAttachment(manufacturerModelId, type);
		if (modelAttachment != null) {
			data = modelAttachment.getAttachment().getAttachment();
		} else {
			throw new ModelImageNotFoundException();
		}
		return data;
	}

	@Override
	public List<ModelDTO> findTopRatedModel(String program) {
		return modelDao.findTopRatedModel(program);
	}
}