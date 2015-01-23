package com.erecyclingcorps.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * @author parora
 **/
public interface BaseDAO<T, Id extends Serializable> {

	public T findByPK(Id id) throws DataAccessException;

	public void saveOrUpdate(T domain) throws DataAccessException;

	public void delete(final Id id) throws DataAccessException;

	public T merge(T entity) throws DataAccessException;

	public void update(T domain) throws DataAccessException;

	public void flush() throws DataAccessException;

	public void save(T domain) throws DataAccessException;

	public List<T> findAll();

	void saveOrUpdateAll(List<T> list);

}
