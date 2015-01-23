package com.erecyclingcorps.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dto.AttributeDTO;

@Transactional(readOnly=true)
public interface AttributeService {

    public List<String> findAttributeNameByMetaData(Long attribute, Long program, String prioritizationCategory);

    public String findDescriptionByPK(Long attribute);

    public List<? extends AttributeDTO> findAllAttributeByProgram(Long programId);

    public Set<String> findAttributeNameByMetaData(Long attribute, Long program, Set<String> categories);

}
