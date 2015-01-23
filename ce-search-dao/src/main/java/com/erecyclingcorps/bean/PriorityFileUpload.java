/*
 * PriorityFileUpload.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.bean;

import org.springframework.web.multipart.MultipartFile;

public class PriorityFileUpload {
	private Long program;
	private MultipartFile file;
	private Long attribute;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Long getProgram() {
		return program;
	}

	public void setProgram(Long programId) {
		this.program = programId;
	}

	public Long getAttribute() {
		return attribute;
	}

	public void setAttribute(Long attributeId) {
		this.attribute = attributeId;
	}

}
