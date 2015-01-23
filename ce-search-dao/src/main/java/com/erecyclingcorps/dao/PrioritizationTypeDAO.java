package com.erecyclingcorps.dao;

import java.io.Serializable;

import com.erecyclingcorps.dao.domain.PrioritizationType;

public interface PrioritizationTypeDAO extends BaseDAO<PrioritizationType, Serializable> {

    public PrioritizationType getPrioritizationTypeListByMetaData(Long program, Long attribute);

}
