package com.erecyclingcorps.service;


import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dao.domain.ProgramCategory;

@Transactional(readOnly = true)
public interface ProgramCategoryService {

	public ProgramCategory findByProgramCategory(Long programId, String prioritizationCategory);

}
