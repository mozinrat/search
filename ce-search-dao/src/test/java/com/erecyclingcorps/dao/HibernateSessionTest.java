package com.erecyclingcorps.dao;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author parora
 **/

public class HibernateSessionTest extends BaseTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private org.springframework.core.env.Environment env;

	@Test(enabled = true)
	public void checkSessionFactory() {
		Assert.assertNotNull(sessionFactory);
	}

	@Test(enabled = true)
	public void checkSession() {
		Assert.assertNotNull(sessionFactory.openSession());
	}

	@Test(enabled = true)
	public void chcekEnvironmentInstance() {
		Assert.assertNotNull(env);
	}

	@Test(enabled = true)
	public void hibernatePropertiesTest() {
		Assert.assertNotNull(env.getProperty("hibernate.format_sql"));
		Assert.assertNotNull(env.getProperty("hibernate.show_sql"));
		Assert.assertNotNull(env.getProperty("hibernate.hbm2ddl.auto"));
		Assert.assertNotNull(env.getProperty("hibernate.dialect"));
	}
	
	@Test(enabled = true)
	public void dataSourceTest() {
		Assert.assertNotNull(dataSource);
	}
	
	
}