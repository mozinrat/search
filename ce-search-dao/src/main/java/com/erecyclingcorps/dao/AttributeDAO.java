package com.erecyclingcorps.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.erecyclingcorps.dao.domain.Attribute;

public interface AttributeDAO extends BaseDAO<Attribute, Serializable> {

	public List<String> findAllByAttribute(Long attribute, Long program, String prioritizationCategory);

	public List<Attribute> findAllAttributeByProgram(Long programId);
	
	public List<String> findAllByAttribute(Long attribute, Long program, Set<String> prioritizationCategory);

}
