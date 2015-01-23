package com.erecyclingcorps.dao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author parora
 * 
 * Generated 24 Nov, 2014 10:40:04 AM  
 **/
@Entity
@Table(name = "ref_locale")
public class Locale implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5270736525225815019L;

	@Id
	@Column(name = "localeid", unique = true, nullable = false)
	private int localeId;

	@Column(name = "localecode")
	private String localeCode;

	@Column(name = "languagename")
	private String languageName;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdby")
	private User createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateddate", nullable = false)
	private Date updatedDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = false)
	private Date createdDate;

	public int getLocaleId() {
		return localeId;
	}

	public void setLocaleId(int localeId) {
		this.localeId = localeId;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
