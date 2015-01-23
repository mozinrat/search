package com.erecyclingcorps.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.PrioritizationTypeDAO;
import com.erecyclingcorps.dao.domain.PrioritizationType;

@Repository
public class PrioritizationTypeDAOImpl extends BaseDAOImpl<PrioritizationType, Serializable> implements PrioritizationTypeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	protected Class<PrioritizationType> getDataClass() {
		return PrioritizationType.class;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public PrioritizationType getPrioritizationTypeListByMetaData(Long program, Long attribute) {
		PrioritizationType prioritizationType = (PrioritizationType) getCurrentSession().createCriteria(PrioritizationType.class).createAlias("program", "p")
				.createAlias("attribute", "attribute").add(Restrictions.eq("p.id", program)).add(Restrictions.eq("attribute.id", attribute)).uniqueResult();
		return prioritizationType;
	}

}
