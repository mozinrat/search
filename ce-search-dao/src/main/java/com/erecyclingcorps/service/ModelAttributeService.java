package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.DiscoverMetaDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;

/**
 * @author prasingh
 **/

@Transactional(readOnly = true)
public interface ModelAttributeService {
    
    @Transactional(readOnly = false)
	public List<String> findModelAttribute(ModelAttributeSearchDTO modelAttributeSearchDTO) throws FilterNotFoundException;

    public DiscoverMetaDTO getSearchAttribute(String program);

}
