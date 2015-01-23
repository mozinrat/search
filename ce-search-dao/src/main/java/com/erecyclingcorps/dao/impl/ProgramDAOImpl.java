package com.erecyclingcorps.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.ProgramDAO;
import com.erecyclingcorps.dao.domain.Program;

@Repository
public class ProgramDAOImpl extends BaseDAOImpl<Program, Long> implements ProgramDAO {

    private static final String FIND_PROGRAM_BY_CODE_QUERY="findProgramByCode";
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	protected Class<Program> getDataClass() {
		return Program.class;
	}

	@Override
	public Long findByCode(String program) {
		return (Long) sessionFactory.getCurrentSession().createQuery("select id from Program where programName=:program")
				.setParameter("program", program).uniqueResult();
	}

	public Program findCurrentUserProgram(String username) {
	    return (Program) sessionFactory.getCurrentSession()
						.createQuery("Select uap from User u join u.application ua join ua.program uap where u.username=:userName")
						.setParameter("userName", username).uniqueResult();
		
	}
	
	@Override
    public Program findProgramByCode(String program) {
        return (Program) sessionFactory.getCurrentSession().getNamedQuery(FIND_PROGRAM_BY_CODE_QUERY)
                .setParameter("program", program).uniqueResult();
    }

}
