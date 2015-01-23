package com.erecyclingcorps.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author parora Generated 24 Nov, 2014 10:40:04 AM
 * 
 **/
@Entity
@Table(name = "ref_filter_attribute", schema = "public")
public class FilterAttribute implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5435910906579128296L;

	@Id
	@Column(name = "filterattributeid", unique = true, nullable = false)
	private long filterAttributeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "attributeid", nullable = false)
	private Attribute Attribute;

	@Column(name = "description")
	private String description;

	@Column(name = "display_order", nullable = false)
	private long displayOrder;

	@Column(name = "isactive", nullable = false)
	private boolean isActive;

	public long getFilterAttributeId() {
		return filterAttributeId;
	}

	public void setFilterAttributeId(long filterAttributeId) {
		this.filterAttributeId = filterAttributeId;
	}

	public Attribute getAttribute() {
		return Attribute;
	}

	public void setAttribute(Attribute attribute) {
		Attribute = attribute;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		this.displayOrder = displayOrder;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
