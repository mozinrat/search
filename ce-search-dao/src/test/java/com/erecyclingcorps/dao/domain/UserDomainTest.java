package com.erecyclingcorps.dao.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author parora
 **/
public class UserDomainTest {

	/**
	 * 
	 */
	
	private User user;
	
	@BeforeClass
	public void populateUser(){
		user = new User();
		user.setActive(Boolean.TRUE);
		user.setApplication(getApplication());
		user.setAuthority(getAuthority());
		user.setContact(getContact());
		user.setCreatedBy(null);
		user.setCreatedDate(new Date(1388552400000l));
		user.setLastChangedPasswordDate(new Date(1388552400000l));
		user.setLastUpdatedDate(new Date(1388552400000l));
		user.setPassword("password");
		user.setShowPreferences(Boolean.FALSE);
		user.setTimeZone("en");
		user.setUpdatedBy(null);
		user.setUserId(101l);
		user.setUsername("fs_rjivan");
		user.setVersion(1l);
		user.setAuthorities(getAuthorities(getAuthority()));
	} 
	
	@Test
	public void userDomainTest(){
		Assert.assertEquals(Boolean.TRUE, user.getActive());
		Assert.assertEquals(getApplication().getApplicationId() ,user.getApplication().getApplicationId());
		Set<Role> roles= user.getAuthority();
		for (Role role : roles) {
			Assert.assertEquals(true,role.getRoleType().equalsIgnoreCase("ROLE_ADMIN"));	
		}
		Assert.assertEquals(true,user.getContact().getEmail().equalsIgnoreCase("test@test.com"));
		Assert.assertEquals(1l,user.getContact().getContactId());
		Assert.assertEquals(null,user.getCreatedBy());
		Assert.assertEquals(null,user.getUpdatedBy());
		Assert.assertEquals(new Date(1388552400000l),user.getCreatedDate());
		Assert.assertEquals(new Date(1388552400000l),user.getLastChangedPasswordDate());
		Assert.assertEquals(new Date(1388552400000l),user.getLastUpdatedDate());
		Assert.assertEquals(101l,user.getUserId());
		Assert.assertEquals(true,user.isAccountNonExpired());
		Assert.assertEquals(true,user.isAccountNonLocked());
		Assert.assertEquals(true,user.isCredentialsNonExpired());
		Assert.assertEquals(true,user.isEnabled()); 
		Assert.assertEquals(true,user.getPassword().equals("password"));
		Assert.assertEquals(Boolean.FALSE,user.getShowPreferences());
		Assert.assertEquals(true,user.getTimeZone().equals("en"));
		Assert.assertEquals(true,user.getUsername().equals("fs_rjivan"));
		Assert.assertEquals(1l,user.getVersion());
		Assert.assertEquals(-1759752022681703533L,User.getSerialversionuid()); 
		Collection<? extends GrantedAuthority> authorities=user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.assertEquals(true,grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
		}
		user.setAuthorities(null);
		authorities=user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			Assert.assertEquals(true,grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
		}
		user.setAuthority(new HashSet<Role>());
		user.setAuthorities(new ArrayList<GrantedAuthority>());
		Assert.assertEquals(0,user.getAuthorities().size());
		user.setAuthorities(null);
		Assert.assertEquals(null,user.getAuthorities());
	}
	
	private Application getApplication(){
		Application application = new Application();
		application.setApplicationId(1l);
		return application;
	}
	
	private Contact getContact(){
		Contact contact = new Contact();
		contact.setContactId(1l);
		contact.setCreatedBy(null);
		contact.setEmail("test@test.com");
		return contact;
	}
	
	private Set<Role> getAuthority(){
		Role role = new Role();
		role.setRoleId(1);
		role.setRoleType("ROLE_ADMIN");
		role.setDescription("ADMIN ROLE");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		return roles;
	}
	
	private Collection<GrantedAuthority> getAuthorities(Set<Role> authority){
		Collection<GrantedAuthority> authorities=null;
		if (!authority.isEmpty() && authorities == null) {
			List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
			for (Role role : authority) {
				listOfAuthorities.add(new SimpleGrantedAuthority(role
						.getRoleType()));
			}
			authorities = listOfAuthorities;
		}
		return authorities;
	}
}
