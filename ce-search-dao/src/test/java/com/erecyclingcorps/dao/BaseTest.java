/*
 * BaseTest.java 4:14:00 PM Dec 2, 2014
 * 
 * Copyright (c)2014 HYLA Mobile, Inc. U.S.A. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of eRecyclingCorps, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with
 * eRecyclingCorps, Inc.
 */
package com.erecyclingcorps.dao;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import com.erecyclingcorps.config.DaoConfigTest;
import com.erecyclingcorps.dao.domain.User;

/**
 * @author parora
 **/

@ContextConfiguration(classes = DaoConfigTest.class)
@Transactional
@EnableTransactionManagement
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class BaseTest extends AbstractTransactionalTestNGSpringContextTests {

	protected User user;

	@Autowired
	private UserDetailsService userDetailsService;

	private String username;
	
	@BeforeClass
	protected void setUp(ITestContext context) {
		username=context.getCurrentXmlTest().getAllParameters().get("userName");
		MockitoAnnotations.initMocks(this);
		setAuthenticatedUser();
	}

	protected void setAuthenticatedUser() {
		user = (User) userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(auth);
	}
	
}
