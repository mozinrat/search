package com.erecyclingcorps.dto;


/**
 * @author parora
 * @version $Id$
 */
public class ModelAttributeDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -341872692552349573L;

	private String code;
	private String label;
	private String tigger;
	private String helptext;
	
	public ModelAttributeDTO() {
	}
	
	public ModelAttributeDTO(String code,String label,String helptext,String tigger) {
		this.code=code;
		this.label=label;
		this.helptext=helptext;
		this.tigger=tigger;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    public String getTigger() {
        return tigger;
    }

    public void setTigger(String tigger) {
        this.tigger = tigger;
    }
	
}