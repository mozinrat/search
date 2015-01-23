package com.erecyclingcorps.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.erecyclingcorps.dto.ProgramDTO;

/**
 * @author parora
 **/

@Entity
@Table(name = "ref_program")
@NamedQueries({
    @NamedQuery(name = "findProgramByCode", query =  "from Program where programName=:program")
})
public class Program implements Serializable,ProgramDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "programid")
	private Long id;
	
	@Column(name = "programname")
	private String programName;
	
	@Column(name = "description")
	private String description;

	@Column(name = "isactive")
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
