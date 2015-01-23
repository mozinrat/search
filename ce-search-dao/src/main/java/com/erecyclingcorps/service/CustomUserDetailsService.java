package com.erecyclingcorps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erecyclingcorps.dao.UserDAO;
import com.erecyclingcorps.dao.domain.User;
 
/**
 * @author parora
 **/

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
 
	@Autowired
	private UserDAO userDao;
 
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
		User user = userDao.loadUserByUsername(username);
		return (UserDetails) user;
	}
 
}