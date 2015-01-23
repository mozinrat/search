/*
 * BaseDAOImpl.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.BaseDAO;

/**
 * @author parora
 **/

@Repository
public abstract class BaseDAOImpl<T, Id extends Serializable> implements BaseDAO<T, Id>  {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public T findByPK(Id id) throws DataAccessException {
		return (T) sessionFactory.getCurrentSession().get(getDataClass(), id);
	}

	@Override
	public void saveOrUpdate(T domain) throws DataAccessException {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
	}

	@Override
	public void delete(Id id) throws DataAccessException {
		sessionFactory.getCurrentSession().delete(findByPK(id));
	}

	public List<T> findAll() {
		return (List<T>) sessionFactory.getCurrentSession().createCriteria(getDataClass()).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public T merge(T entity) throws DataAccessException {
		return (T) sessionFactory.getCurrentSession().merge(entity);
	}

	@Override
	public void update(T domain) throws DataAccessException {
		sessionFactory.getCurrentSession().update(domain);
	}

	@Override
	public void flush() throws DataAccessException {
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void save(T domain) throws DataAccessException {
		sessionFactory.getCurrentSession().save(domain);
	}

	@Override
	public void saveOrUpdateAll(List<T> list) {
		int count = 0;
		Session session = sessionFactory.getCurrentSession();
		for (T t : list) {
			session.saveOrUpdate(t);
			if (++count % 50 == 0) {
				session.flush();
				session.clear();
			}
		}
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	protected abstract Class<T> getDataClass();

}
