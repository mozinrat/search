package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ModelMappingService {

	/**
	 * 
	 * @param csvByte
	 * @return
	 */
	public Map<String, Object> getModelMappingBeansFromCSV(byte[] csvByte);

	public List<String> validateCSV(Map<String, Object> modelMappingBeansFromCSV, Long program, Long attribute);
}