package com.erecyclingcorps.dao;

import com.erecyclingcorps.dao.domain.ProgramCategory;

public interface ProgramCategoryDAO {

	ProgramCategory findByProgramCategory(Long programId, String prioritizationCategory);
	public Long getIdbyProgram(String program, String category);

}
