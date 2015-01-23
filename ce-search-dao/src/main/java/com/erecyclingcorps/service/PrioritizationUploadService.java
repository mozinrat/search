package com.erecyclingcorps.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.bean.PriorityFileUpload;

@Transactional(readOnly=true)
public interface PrioritizationUploadService {
	public byte[] getFile(Long attributeId, Long program);

	public void save(byte[] modelMappingFileBytes, Long attributeId, Long programId, String username);
	
	@Transactional(readOnly=false)
	public Map<String, Object> createValidateFile(PriorityFileUpload fileUpload) throws IOException;
}
