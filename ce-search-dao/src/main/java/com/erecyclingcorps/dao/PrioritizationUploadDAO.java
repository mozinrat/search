package com.erecyclingcorps.dao;

import java.io.Serializable;

import com.erecyclingcorps.dao.domain.PrioritizationType;
import com.erecyclingcorps.dao.domain.PrioritizationUpload;

public interface PrioritizationUploadDAO extends BaseDAO<PrioritizationUpload, Serializable> {

	byte[] getFile(PrioritizationType prioritizationType);

	void deleteByPrioritizationType(PrioritizationType prioritizationType);

}
