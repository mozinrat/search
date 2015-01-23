package com.erecyclingcorps.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.PrioritizationDAO;
import com.erecyclingcorps.dao.domain.Prioritization;
import com.erecyclingcorps.dao.domain.PrioritizationType;

@Repository
public class PrioritizationDAOImpl extends BaseDAOImpl<Prioritization, Serializable> implements PrioritizationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	protected Class<Prioritization> getDataClass() {
		return Prioritization.class;
	}

	@Override
	public Prioritization findByPrioritizationString(String prioritizationString, PrioritizationType prioritizationType) {
		return (Prioritization) getCurrentSession().createCriteria(Prioritization.class).createAlias("prioritizationType", "pt")
				.add(Restrictions.eq("value", prioritizationString).ignoreCase()).add(Restrictions.eq("pt.id", prioritizationType.getId()))
				.uniqueResult();
	}

	@Override
	public void updateOldByPrioritizationType(PrioritizationType prioritizationType) {
		getCurrentSession().createQuery("update Prioritization p set p.active = false where p.prioritizationType.id=:prioritizationTypeId")
				.setParameter("prioritizationTypeId", prioritizationType.getId()).executeUpdate();
	}

}
