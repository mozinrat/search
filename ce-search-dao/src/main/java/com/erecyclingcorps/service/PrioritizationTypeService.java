package com.erecyclingcorps.service;


import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dao.domain.PrioritizationType;

@Transactional(readOnly=true)
public interface PrioritizationTypeService {
	
	public PrioritizationType getPrioritizationTypeListByMetaData(Long program, Long attribute);

}
