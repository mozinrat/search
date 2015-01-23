package com.erecyclingcorps.dao.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.erecyclingcorps.dto.AttributeDTO;

@Entity
@Table(name = "ref_attribute")
public class Attribute implements Serializable,AttributeDTO {
	/**
	 * @author bbansal
	 * 
	 *         Generated 24 Nov, 2014 10:40:04 AM
	 **/
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "attributeid")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "createdby")
	private User createdBy;

	@Column(name = "createddate")
	private Date createdDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;

	@Column(name = "updateddate")
	private Date updatedDate;
	
	@OneToMany(mappedBy="attribute",fetch=FetchType.LAZY)
	private Set<PrioritizationType> prioritizationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
