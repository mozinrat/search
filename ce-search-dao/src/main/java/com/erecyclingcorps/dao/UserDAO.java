package com.erecyclingcorps.dao;

import org.springframework.stereotype.Repository;

import com.erecyclingcorps.dao.domain.User;

/**
 * @author parora
 **/

@Repository
public interface UserDAO {

	User findByUserName(String username);

	User loadUserByUsername(String username);

}
