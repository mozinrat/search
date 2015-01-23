/*
 * ModelMappingCsvUploadBean.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.bean;

import java.io.Serializable;

public class ModelMappingCsvUploadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchPrioritizationId;

	private String prioritizationString;

	private String prioritizationRanking;

	private String prioritizationCategory;

	public String getSearchPrioritizationId() {
		return searchPrioritizationId;
	}

	public void setSearchPrioritizationId(String searchPrioritizationId) {
		this.searchPrioritizationId = searchPrioritizationId;
	}

	public String getPrioritizationString() {
		return prioritizationString;
	}

	public void setPrioritizationString(String prioritizationString) {
		this.prioritizationString = prioritizationString;
	}

	public String getPrioritizationRanking() {
		return prioritizationRanking;
	}

	public void setPrioritizationRanking(String prioritizationRanking) {
		this.prioritizationRanking = prioritizationRanking;
	}

	public String getPrioritizationCategory() {
		return prioritizationCategory;
	}

	public void setPrioritizationCategory(String prioritizationCategory) {
		this.prioritizationCategory = prioritizationCategory;
	}

}
