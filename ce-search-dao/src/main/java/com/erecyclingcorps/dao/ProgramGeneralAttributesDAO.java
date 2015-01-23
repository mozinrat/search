package com.erecyclingcorps.dao;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.domain.ProgramGenAttribute;

@Repository
public interface ProgramGeneralAttributesDAO extends BaseDAO<ProgramGenAttribute, Serializable> {

	/**
	 * Method used to get CE_APP DATA to make rest request to ce-app for model search.
	 * @param program
	 * @return Map<String, String>
	 */
	public Map<String, String> getAPIData(String program);
	public Map<String, String> getBannerData(String program) ;
}
