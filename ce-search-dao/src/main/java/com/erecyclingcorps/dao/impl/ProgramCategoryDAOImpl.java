package com.erecyclingcorps.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ProgramCategoryDAO;
import com.erecyclingcorps.dao.domain.ProgramCategory;
import com.erecyclingcorps.utils.Constants;


@Repository
public class ProgramCategoryDAOImpl extends BaseDAOImpl<ProgramCategory, Serializable> implements ProgramCategoryDAO {
	
    public static final String HQL = "select pc.id from ProgramCategory pc"
                            +" join pc.program pro with pro.programName = :programValue "
                            +" join pc.category cat with cat.code= :categoryValue";
    @Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public ProgramCategory findByProgramCategory(Long programId, String prioritizationCategory) {
		return (ProgramCategory) getCurrentSession().createCriteria(ProgramCategory.class).createAlias(Constants.PROGRAM, Constants.PROGRAM)
				.createAlias(Constants.CATEGORY, Constants.CATEGORY).add(Restrictions.eq(Constants.PROGRAM_ID, programId))
				.add(Restrictions.eq(Constants.CATEGORY_CODE, prioritizationCategory).ignoreCase()).uniqueResult();
	}

	@Override
	protected Class<ProgramCategory> getDataClass() {
		return ProgramCategory.class;
	}
	
	/**
	 * This method is created to be cachable and return programcategoryid 
	 * based on program and category. This is a common join everywhere and
	 * can easily replaced with this cachable call.
	 */
	
    @Override
    public Long getIdbyProgram(String program, String category) {
        Query query =sessionFactory.getCurrentSession().createQuery(HQL);  
        query.setParameter("programValue", program);
        query.setParameter("categoryValue", category);
        List<Long> ids = query.list();
        return !ids.isEmpty()?ids.get(0):-1; // -1 returns an invalid program
    }

}
