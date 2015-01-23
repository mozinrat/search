/*
 * ModelSearchDTO.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dto;

import java.util.HashMap;
import java.util.Map;

import com.erecyclingcorps.utils.Constants;
/**
 * @author parora
 * @version $Id$
 */
public class ModelSearchDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String searchText;
	private String batchSize = Constants.MODEL_BATCH_SIZE;
	private String startAt;
    private Map<String,String> filters = new HashMap<String,String>(1);
	private String program;
	
	public ModelSearchDTO() {
	}
	
	public ModelSearchDTO(String searchText, String batchsize, String startat,
			Map<String,String> filters, String program) {
		this.searchText = searchText;
		this.batchSize = batchsize;
		this.startAt = startat;
		this.filters = filters;
		this.program = program;
	}
	
	public ModelSearchDTO(String searchText, String batchsize, String startat,
             String program) {
        this.searchText = searchText;
        this.batchSize = batchsize;
        this.startAt = startat;
        this.program = program;
    }
	/**
	 * @return the searchtext
	 */
	public String getSearchText() {
		return searchText;
	}
	/**
	 * @param searchtext the searchtext to set
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	/**
	 * @return the startat
	 */
	public String getStartAt() {
		return startAt;
	}
	/**
	 * @param startat the startat to set
	 */
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	
	/**
	 * @return the batchSize
	 */
	public String getBatchSize() {
		return batchSize;
	}

	/**
	 * @param batchSize the batchSize to set
	 */
	public void setBatchSize(String batchSize) {
		this.batchSize = batchSize;
	}

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    public void addFilters(String key,  String value) {
        this.filters.put(key, value);
    }
}