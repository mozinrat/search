package com.erecyclingcorps.dao;

import com.erecyclingcorps.dao.domain.Program;

public interface ProgramDAO extends BaseDAO<Program, Long> {

	public Long findByCode(String program);

	public Program findCurrentUserProgram(String username);

    public Program findProgramByCode(String program);

}
