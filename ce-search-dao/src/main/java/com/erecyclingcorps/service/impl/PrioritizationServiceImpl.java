/*
 * PrioritizationServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.bean.ModelMappingCsvUploadBean;
import com.erecyclingcorps.dao.PrioritizationDAO;
import com.erecyclingcorps.dao.domain.Prioritization;
import com.erecyclingcorps.dao.domain.PrioritizationType;
import com.erecyclingcorps.service.PrioritizationService;
import com.erecyclingcorps.service.PrioritizationTypeService;
import com.erecyclingcorps.service.ProgramCategoryService;

@Service
public class PrioritizationServiceImpl implements PrioritizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrioritizationServiceImpl.class);

	@Autowired
	private PrioritizationDAO prioritizationDAO;
	@Autowired
	private ProgramCategoryService programCategoryService;
	@Autowired
	private PrioritizationTypeService prioritizationTypeService;

	private void updateOldByPrioritizationType(PrioritizationType prioritizationType) {
		prioritizationDAO.updateOldByPrioritizationType(prioritizationType);
	}

	@Override
	public boolean saveFile(List<ModelMappingCsvUploadBean> csvMappedBean, Long attributeId, Long programId) {
		List<Prioritization> prioritizations = new ArrayList<Prioritization>(0);
		PrioritizationType prioritizationType = prioritizationTypeService.getPrioritizationTypeListByMetaData(programId, attributeId);
		updateOldByPrioritizationType(prioritizationType);
		try {
			for (ModelMappingCsvUploadBean mappingCsvUploadBean : csvMappedBean) {
				Prioritization prioritization = new Prioritization();
				prioritization.setValue(mappingCsvUploadBean.getPrioritizationString());
				prioritization.setRanking(Integer.parseInt(mappingCsvUploadBean.getPrioritizationRanking()));
				prioritization.setActive(true);
				prioritization.setPrioritizationType(prioritizationType);
				prioritization.setProgramCategory(programCategoryService.findByProgramCategory(programId,
						mappingCsvUploadBean.getPrioritizationCategory()));
				prioritizations.add(prioritization);
			}
			prioritizationDAO.saveOrUpdateAll(prioritizations);
		} catch (Exception e) {
		    LOGGER.error(e.getMessage(),e);
		    return false;
		}
		return true;
	}

}
