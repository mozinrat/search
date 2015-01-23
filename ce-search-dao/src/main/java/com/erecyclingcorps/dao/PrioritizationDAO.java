package com.erecyclingcorps.dao;

import java.io.Serializable;

import com.erecyclingcorps.dao.domain.Prioritization;
import com.erecyclingcorps.dao.domain.PrioritizationType;

public interface PrioritizationDAO extends BaseDAO<Prioritization, Serializable> {

    public Prioritization findByPrioritizationString(String prioritizationString, PrioritizationType prioritizationType);

    public void updateOldByPrioritizationType(PrioritizationType prioritizationType);

}
