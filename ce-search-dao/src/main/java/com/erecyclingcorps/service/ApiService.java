package com.erecyclingcorps.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ApiService {

	/**
	 * Method used to get CE_APP DATA to make rest request to ce-app for model search.
	 * 
	 * @param program
	 * @return Map<String, String>
	 */
	public Map<String, String> getAPIData(String program);
	public Map<String, String> getBannerData(String program);
}
