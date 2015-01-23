/*
 * ModelServiceTest.java 4:14:00 PM Dec 2, 2014
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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.AttachmentType;
import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;
import com.erecyclingcorps.exceptions.ModelImageNotFoundException;

/**
 * @author parora
 **/

public class ModelServiceTest extends BaseTest {

	@Autowired
	private ModelService modelService;

	@Test(enabled = true)
	public void getModelAttachmentTest(ITestContext context) throws ModelImageNotFoundException {
		Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
		ModelSearchDTO modelSearchDTO =new ModelSearchDTO(testParams.get("searchText"), testParams.get("batchSize"),testParams.get("startAt"), testParams.get("program"));
		List<ModelDTO> models = modelService.findModel(modelSearchDTO);
		for (ModelDTO model : models) {
			byte[] buffer = modelService.getModelAttachment(model.getManufacturerModelId(), AttachmentType.MODEL_IMAGE_SMALL);
			Assert.assertNotNull(buffer);
		}
	}

	@Test(enabled = true, expectedExceptions = ModelImageNotFoundException.class)
	public void getModelAttachmentExceptionTest() throws ModelImageNotFoundException {
		modelService.getModelAttachment(-1l, AttachmentType.MODEL_IMAGE_SMALL);
	}

	@DataProvider(name = "ModelTestDataProvider")
	public static Object[][] modelAttributesWithPositiveInput(ITestContext context) {
		Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
		return new Object[][] { {new ModelSearchDTO(testParams.get("searchText"), testParams.get("batchSize"),testParams.get("startAt"), testParams.get("program"))}};
	}

	@Test(enabled = true, dataProvider = "ModelTestDataProvider")
	public void findModelTest(ModelSearchDTO modelSearchDTO) {
		List<ModelDTO> models = modelService.findModel(modelSearchDTO);
		Assert.assertNotNull(models);
		Assert.assertNotEquals(0, models.size());
		for (ModelDTO model : models) {
			Assert.assertNotNull(model.getLabel());
			Assert.assertNotNull(model.getId());
			Assert.assertNotNull(model.getManufacturerModelId());
			Assert.assertNotNull(model.getModelcode());
			//Assert.assertNotNull(model.getImage());
		}
	}

	@DataProvider(name = "findTopRatedModelDataProvider")
	public static Object[][] findTopRatedModelInput(ITestContext context) {
		Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
		return new Object[][] { {testParams.get("program")}
		};
	}

	@Test(enabled = true, dataProvider = "findTopRatedModelDataProvider")
	public void findTopRatedModel(String program) {
		List<ModelDTO> models = modelService.findTopRatedModel(program);
		Assert.assertNotNull(models);
		for (ModelDTO model : models) {
			Assert.assertNotNull(model.getLabel());
			Assert.assertNotNull(model.getId());
			Assert.assertNotNull(model.getManufacturerModelId());
			Assert.assertNotNull(model.getModelcode());
			Assert.assertNotNull(model.getImage());
		}
	}

}
