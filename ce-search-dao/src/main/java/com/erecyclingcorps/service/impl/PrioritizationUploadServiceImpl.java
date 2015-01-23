/*
 * PrioritizationUploadServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.bean.ModelMappingCsvUploadBean;
import com.erecyclingcorps.bean.PriorityFileUpload;
import com.erecyclingcorps.dao.PrioritizationUploadDAO;
import com.erecyclingcorps.dao.domain.PrioritizationType;
import com.erecyclingcorps.dao.domain.PrioritizationUpload;
import com.erecyclingcorps.dao.domain.User;
import com.erecyclingcorps.service.ModelMappingService;
import com.erecyclingcorps.service.PrioritizationService;
import com.erecyclingcorps.service.PrioritizationTypeService;
import com.erecyclingcorps.service.PrioritizationUploadService;
import com.erecyclingcorps.utils.Constants;

@Service
public class PrioritizationUploadServiceImpl implements PrioritizationUploadService {
	@Autowired
	private PrioritizationUploadDAO prioritizationUploadDAO;
	@Autowired
	private PrioritizationTypeService prioritizationTypeService;
	@Autowired
	private ModelMappingService modelMappingService;
	@Autowired
	private PrioritizationService prioritizationService;

	@Override
	public byte[] getFile(Long attributeId, Long program) {
		return prioritizationUploadDAO.getFile(prioritizationTypeService.getPrioritizationTypeListByMetaData(program, attributeId));
	}

	public void deleteByPrioritizationType(PrioritizationType prioritizationType) {
		prioritizationUploadDAO.deleteByPrioritizationType(prioritizationType);
	}

	@Override
	public void save(byte[] modelMappingFileBytes, Long attributeId, Long programId, String username) {
		PrioritizationType prioritizationType = prioritizationTypeService.getPrioritizationTypeListByMetaData(programId, attributeId);
		deleteByPrioritizationType(prioritizationType); 
		PrioritizationUpload prioritizationUpload = new PrioritizationUpload();
		prioritizationUpload.setFileByteArray(modelMappingFileBytes);
		prioritizationUpload.setPrioritizationType(prioritizationType);
		prioritizationUpload.setUploadedtime(new Date());
		prioritizationUpload.setUploadedby(username);
		prioritizationUpload.setStatus(Constants.SUCCESS);
		prioritizationUploadDAO.saveOrUpdate(prioritizationUpload);
	}

	@Override
	public Map<String, Object> createValidateFile(PriorityFileUpload fileUpload) throws IOException {
		Map<String, Object> fileResult = new HashMap<String, Object>();
		Map<String, Object> modelMappingBeansFromCSV = modelMappingService.getModelMappingBeansFromCSV(fileUpload.getFile().getBytes());
		List<String> fileErrors = modelMappingService.validateCSV(modelMappingBeansFromCSV, fileUpload.getProgram(), fileUpload.getAttribute());
		fileResult.put("hasError", false);
		fileResult.put("fileUploaded", false);
		if (!fileErrors.isEmpty()) {
			fileResult.put("hasError", true);
			fileResult.put("fileErrors", fileErrors);
		} else if (prioritizationService.saveFile((List<ModelMappingCsvUploadBean>) modelMappingBeansFromCSV.get(Constants.MODEL_MAPPING_CSV_BEAN), fileUpload.getAttribute(),
				fileUpload.getProgram())) {
			fileResult.put("fileUploaded", true);
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			save(fileUpload.getFile().getBytes(), fileUpload.getAttribute(), fileUpload.getProgram(), user.getUsername());
		}
		return fileResult;
	}

}
