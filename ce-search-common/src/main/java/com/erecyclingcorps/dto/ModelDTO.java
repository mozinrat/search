/*
 * ModelDTO.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dto;

import com.erecyclingcorps.utils.Constants;


/**
 * @author parora
 * @version $Id$
 */
public class ModelDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -341872692552349573L;
	private Long id;
	private String modelcode;
	private Long manufacturerModelId;
	private String label;
	private String image;
	private Integer searchOrder;
	
	public ModelDTO() {
	}
	
	public String getModelcode() {
		return modelcode;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	public String getImage() {
		return Constants.MODEL+String.valueOf(manufacturerModelId)+Constants.MODEL_IMAGE_SMALL_BASE_URL;
	}

	public void setImage() {
	    this.image=Constants.MODEL+String.valueOf(manufacturerModelId)+Constants.MODEL_IMAGE_SMALL_BASE_URL;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getManufacturerModelId() {
		return manufacturerModelId;
	}

	public void setManufacturerModelId(Long manufacturerModelId) {
		this.manufacturerModelId = manufacturerModelId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the searchOrder
	 */
	public Integer getSearchOrder() {
		return searchOrder;
	}

	/**
	 * @param searchOrder the searchOrder to set
	 */
	public void setSearchOrder(Integer searchOrder) {
		this.searchOrder = searchOrder;
	}
}
