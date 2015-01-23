/*
 * ModelDAOImplTest.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dao.ModelDAO;
import com.erecyclingcorps.dao.domain.ModelAttachment;
import com.erecyclingcorps.dao.domain.ProgramManufacturerModel;
import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;


/**
 * @author parora
 **/

public class ModelDAOImplTest extends BaseTest {
	
	@Autowired
	private ModelDAO modelDAO;
	
	@Test
   public void getValidDaoObjectTest() {
		Assert.assertNotNull(modelDAO);
   }
	
	@Test
   public void getClassTest() {
		Assert.assertEquals(true,modelDAO.getClass().getName().equals(ModelDAOImpl.class.getName()));
   }
	
	@Test
   public void getDataClassTest() {
		if(modelDAO instanceof ModelDAOImpl){
			ModelDAOImpl modelDAOImpl= (ModelDAOImpl) modelDAO;
			Assert.assertEquals(true, modelDAOImpl.getDataClass().getName().equals(ProgramManufacturerModel.class.getName()));	
		}
   }
	
	
	@Test(enabled = true)
	public void getModelAttachmentTest(){
		ModelSearchDTO modelSearchDTO = new ModelSearchDTO("e60", "100", "0",  "ATT");
		List<ModelDTO> models = modelDAO.findModel(modelSearchDTO);
		for (ModelDTO model : models) {
			ModelAttachment modelAttachment=modelDAO.getModelAttachment(model.getManufacturerModelId(), AttachmentType.MODEL_IMAGE_SMALL);
			if(null!=modelAttachment){
				Assert.assertNotNull(modelAttachment.getAttachment());
			}
		}
	}
	
	
}

