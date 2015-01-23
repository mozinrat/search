package com.erecyclingcorps.dao.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author parora
 **/

@Entity
@Table(name = "ref_role")
public class Role implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 895321048240082267L;

	@Id
	@Column(name = "roleid")
	@GeneratedValue
	private float roleId;
	
	@Column(name = "version", nullable = false)
	private long version;
	
	@Column(name = "type")
	private String roleType;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy="authority")
	private Set<User> users = new HashSet<User>();
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRoleId() {
		return roleId;
	}

	public void setRoleId(float roleId) {
		this.roleId = roleId;
	}

	public Set<User> getUsers() {
	  return users;
	}

	public void setUsers(Set<User> users) {
	  this.users = users;
	}

}