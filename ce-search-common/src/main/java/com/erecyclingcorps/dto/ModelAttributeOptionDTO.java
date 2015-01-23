package com.erecyclingcorps.dto;

/**
 * @author parora
 * @version $Id$
 */
public class ModelAttributeOptionDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -341872692552349573L;

	private String name;
	private String label;
	private int sortOrder;

	public ModelAttributeOptionDTO() {
	}
	
	public ModelAttributeOptionDTO(String name, String label, int sortOrder) {
		this.name= name;
		this.label= label;
		this.sortOrder= sortOrder;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the sortOrder
	 */
	public int getSortOrder() {
		return sortOrder;
	}

	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
}