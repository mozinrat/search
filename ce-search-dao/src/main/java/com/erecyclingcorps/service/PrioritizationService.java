package com.erecyclingcorps.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.erecyclingcorps.bean.ModelMappingCsvUploadBean;

@Transactional(readOnly=true)
public interface PrioritizationService {

	@Transactional(readOnly=false)
	public boolean saveFile(List<ModelMappingCsvUploadBean> csvMappedBean, Long attributeId, Long programId);

}
