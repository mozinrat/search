/*
 * ModelMappingServiceImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import liquibase.util.csv.opencsv.bean.CsvToBean;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.bean.ModelMappingCsvUploadBean;
import com.erecyclingcorps.service.AttributeService;
import com.erecyclingcorps.service.ModelMappingService;
import com.erecyclingcorps.service.ProgramCategoryService;
import com.erecyclingcorps.utils.Constants;
import com.erecyclingcorps.utils.CustomHeaderColumnNameMappingStrategy;

/**
 * Class used for validating and creating beans from CSV file.
 * 
 * @author bbansal
 *
 */
@Service("modelMappingService")
public class ModelMappingServiceImpl implements ModelMappingService {
    @Autowired
    private ProgramCategoryService programCategoryService;
    @Autowired
    private AttributeService attributeService;

    private MessageSourceAccessor messageSourceAccessor;

    @Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }

    /**
     * Methods used to create mapping bean from CSV file.
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map getModelMappingBeansFromCSV(byte[] csvByte) {
        CustomHeaderColumnNameMappingStrategy mappingStrategy = new CustomHeaderColumnNameMappingStrategy();
        mappingStrategy.setType(ModelMappingCsvUploadBean.class);
        CsvToBean csvToBean = new CsvToBean();
        List<ModelMappingCsvUploadBean> modelMappingCsvUploadBean =
                csvToBean.parse(mappingStrategy, new InputStreamReader(new BOMInputStream(new ByteArrayInputStream(csvByte))));
        Map<String, List<?>> modelMappingMap = new HashMap<String, List<?>>();
        modelMappingMap.put(Constants.MODEL_MAPPING_CSV_BEAN, modelMappingCsvUploadBean);
        modelMappingMap.put(Constants.INVALID_HEADER_NAMES, mappingStrategy.getInvalidHeadersList());
        return modelMappingMap;
    }

    /**
     * Method used to validate CSV file headers.
     */
    @Override
    public List<String> validateCSV(Map<String, Object> modelMappingBeansFromCSV, Long program, Long attribute) {
        List<String> fileErrors = new ArrayList<String>(0);
        Set<String> invalidHeadersNameSet = headersSet((List<String>) modelMappingBeansFromCSV.get(Constants.INVALID_HEADER_NAMES));
        if (!invalidHeadersNameSet.isEmpty()) {
            for (String string : invalidHeadersNameSet) {
                fileErrors.add(messageSourceAccessor.getMessage("label.invalid.header", new Object[] {string}));
                break;
            }
        } else {
            List<ModelMappingCsvUploadBean> modelMappingBeans = (List<ModelMappingCsvUploadBean>) modelMappingBeansFromCSV.get("modelMappingCsvBeans");
            if (modelMappingBeans.isEmpty()) {
                fileErrors.add(messageSourceAccessor.getMessage("label.priority.file.empty"));
            } else {
                fileErrors.addAll(validateCSVFileData(modelMappingBeans, program, attribute));
            }
        }
        return fileErrors;
    }

    /**
     * Method used to validate CSV file data against rules such as non empty ,duplicate value,valid
     * syntax.
     * 
     * @param modelMappingBeansFromCSVList
     * @param program
     * @param attributeId
     * @return List<String> fileErrors
     */
    private List<String> validateCSVFileData(List<ModelMappingCsvUploadBean> modelMappingBeansFromCSVList, Long program, Long attributeId) {
        int count = 0;
        List<String> fileErrors = new ArrayList<String>(0);
        Set<String> dupCheck = new HashSet<String>(10);
        String attributeDesc = attributeService.findDescriptionByPK(attributeId);
        Set<String> attributes = attributeService.findAttributeNameByMetaData(attributeId, program,getDisctinctCategories(modelMappingBeansFromCSVList));
        for (ModelMappingCsvUploadBean record : modelMappingBeansFromCSVList) {
            count++;
            if (StringUtils.isEmpty(record.getPrioritizationRanking())) {
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationranking.empty", new Object[] {count}));
            } else if (!StringUtils.isNumeric(record.getPrioritizationRanking())) {
                /*PrioritizationRanking should be a number only*/
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationranking.invalid", new Object[] {record.getPrioritizationRanking(),
                        count}));
            } else if (StringUtils.isEmpty(record.getSearchPrioritizationId())) {
                /*SearchPrioritizationId shouldn't be not null*/
                fileErrors.add(messageSourceAccessor.getMessage("label.searchprioritizationid.empty", new Object[] {count}));
            } else if (!record.getSearchPrioritizationId().matches(Constants.PRIORITIZATION_STRING_REGEX)) {
                /*SearchPrioritizationId should be alphanumeric say A1, L2 */
                fileErrors.add(messageSourceAccessor.getMessage("label.searchprioritizationid.invalid", new Object[] {record.getSearchPrioritizationId(),count}));
            } else if (StringUtils.isEmpty(record.getPrioritizationCategory())) {
                /*SearchPrioritization Category shouldn't be not null*/
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationcategory.empty", new Object[] {count}));
            } else if (programCategoryService.findByProgramCategory(program, record.getPrioritizationCategory()) == null) {
                /*SearchPrioritization Category should  be valid*/
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationcategory.invalid", new Object[] {record.getPrioritizationCategory(),count}));
            } else if (StringUtils.isEmpty(record.getPrioritizationString())) {
                /*SearchPrioritization String shouldn't be not null*/
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationstring.empty", new Object[] {attributeDesc, count}));
            } else if(!dupCheck.add(record.getPrioritizationString())){
                /* When duplicate records are uploaded say same multiple model codes */
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationstring.duplicate", new Object[] {attributeDesc, record.getPrioritizationString(),count}));
            } else if(attributes==null || attributes.isEmpty()){
                /* When  records  are not present/returned in database */
                fileErrors.add(messageSourceAccessor.getMessage("label.attributes.empty", new Object[] {attributeDesc, record.getPrioritizationString(), count}));
            }else if(!attributes.contains(record.getPrioritizationString()+"::"+record.getPrioritizationCategory())){
                /* When invalid records are uploaded , records which are not present in database */
                fileErrors.add(messageSourceAccessor.getMessage("label.prioritizationstring.invalid", new Object[] {attributeDesc, record.getPrioritizationString(), count}));
            }
        }
        return fileErrors;
    }

    /**
     * Method used to get header set for CSV file data.
     * 
     * @param headerList
     * @return
     */
    private Set<String> headersSet(List<String> headerList) {
        Set<String> headerSet = new HashSet<String>();
        for (String header : headerList) {
            headerSet.add(header.toLowerCase());
        }
        return headerSet;
    }

    private Set<String> getDisctinctCategories(List<ModelMappingCsvUploadBean> modelMappingBeansFromCSVList) {
        Set<String> categories = new HashSet<String>(10);
        for (ModelMappingCsvUploadBean record : modelMappingBeansFromCSVList) {
            if(!StringUtils.isBlank(record.getPrioritizationCategory())){
                categories.add(record.getPrioritizationCategory());
            }
        }
        return categories;
    }
}
