package com.erecyclingcorps.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ref_prioritization")
public class Prioritization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prioritizationid")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "prioritizationtypeid")
	private PrioritizationType prioritizationType;
	@Column(name = "value")
	private String value;
	@Column(name = "ranking")
	private Integer ranking;
	@Column(name = "active")
	private boolean active;
	@ManyToOne
	@JoinColumn(name="programcategoryid")
	private ProgramCategory programCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrioritizationType getPrioritizationType() {
		return prioritizationType;
	}

	public void setPrioritizationType(PrioritizationType prioritizationType) {
		this.prioritizationType = prioritizationType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ProgramCategory getProgramCategory() {
		return programCategory;
	}

	public void setProgramCategory(ProgramCategory programCategory) {
		this.programCategory = programCategory;
	}

}
