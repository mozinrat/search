package com.erecyclingcorps.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author parora
 **/

@Transactional(readOnly = true)
public interface UserService {

	public Map<String,Object> getCurrentUserProgramList();
	
	public Map<String,Object> getUserProgramDataOnLoad();

}
