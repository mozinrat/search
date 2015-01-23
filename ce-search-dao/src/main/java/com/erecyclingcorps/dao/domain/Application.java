package com.erecyclingcorps.dao.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.erecyclingcorps.dto.ApplicationDTO;

/**
 * @author parora
 * 
 * Generated 24 Nov, 2014 10:40:04 AM  
 **/
@Entity
@Table(name = "ref_application", schema = "public")
public class Application implements java.io.Serializable,ApplicationDTO {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "applicationid", unique = true, nullable = false)
	private Long applicationId;

	@ManyToOne
	@JoinColumn(name = "programid", nullable = false)
	private Program program;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdby")
	private User createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateddate")
	private Date updatedDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate")
	private Date createddate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "application")
	private Set<User> users = new HashSet<User>();

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
