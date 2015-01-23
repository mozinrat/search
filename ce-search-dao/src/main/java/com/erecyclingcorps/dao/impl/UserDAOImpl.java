package com.erecyclingcorps.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.UserDAO;
import com.erecyclingcorps.dao.domain.User;

/**
 * @author parora
 **/

@Repository
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

	private static final String USER_ROLE_QUERY = "getUserWithRole";
	private static final String GET_USER_FROM_USERNAME_QUERY = "from User where username=:username";
	private static final String ATTR_USERNAME = "username";

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	protected Class<User> getDataClass() {
		return User.class;
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		users = sessionFactory.getCurrentSession()
				.createQuery(GET_USER_FROM_USERNAME_QUERY)
				.setParameter(ATTR_USERNAME, username).list();
		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public User loadUserByUsername(String username) {
		User user = (User) sessionFactory.getCurrentSession()
				.getNamedQuery(USER_ROLE_QUERY)
				.setParameter(ATTR_USERNAME, username).uniqueResult();
		return user;
	}

}
