package com.erecyclingcorps.dao.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author parora
 **/

@Entity
@Table(name = "ref_program_manufacturer_model")
public class ProgramManufacturerModel {

	@Id
	@Column(name = "programmodelcatgid")
	private Long id;

	@Version
	@Column(name = "version", nullable = false)
	private long version;

	@Column(name = "carriersku", nullable = false)
	private String carriersku;

	@Column(name = "search_order", nullable = false)
	private long searchOrder;

	@Column(name = "createddate", nullable = false)
	private Date createdDate;

	@Column(name = "lastupdateddate", nullable = false)
	private Date lastUpdatedDate;
	
	@Column(name = "carrier", nullable = true)
	private String[] carrier;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdby")
	private User createdBy;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedby")
	private User updatedBy;

	@ManyToOne
	@JoinColumn(name = "manufacturermodelid")
	private ManufacturerModel manufacturerModel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "programcategoryid", nullable = false)
	private ProgramCategory programCategory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getCarriersku() {
		return carriersku;
	}

	public void setCarriersku(String carriersku) {
		this.carriersku = carriersku;
	}

	public long getSearchOrder() {
		return searchOrder;
	}

	public void setSearchOrder(long searchOrder) {
		this.searchOrder = searchOrder;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public ManufacturerModel getManufacturerModel() {
		return manufacturerModel;
	}

	public void setManufacturerModel(ManufacturerModel manufacturerModel) {
		this.manufacturerModel = manufacturerModel;
	}

	
	public ProgramCategory getProgramCategory() {
		return programCategory;
	}

	public void setProgramCategory(ProgramCategory programCategory) {
		this.programCategory = programCategory;
	}

    public String[] getCarrier() {
        return carrier;
    }

    public void setCarrier(String[] carrier) {
        this.carrier = carrier;
    }

}
