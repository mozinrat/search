package com.erecyclingcorps.service;

import java.util.List;

import javax.transaction.Transactional;

import com.erecyclingcorps.dto.ProgramDTO;

@Transactional
public interface ProgramService {
	List<? extends ProgramDTO> getAllPrograms();
	
	public ProgramDTO findCurrentUserProgram(String username);
}
