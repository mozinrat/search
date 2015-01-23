package com.erecyclingcorps.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.erecyclingcorps.dto.PrioritizationTypeDTO;

@Entity
@Table(name = "ref_prioritizationtype")
public class PrioritizationType implements Serializable,PrioritizationTypeDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "prioritizationtypeid")
	private Long id;
	
	@Column(name = "priority")
	private Long priority;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "attributeid")
	private Attribute attribute;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "programid")
	private Program program;

	@Column(name = "ishidden")
    private Boolean isHidden;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

}
