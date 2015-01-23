package com.erecyclingcorps.dto;

import java.util.HashMap;
import java.util.Map;

public class ModelAttributeSearchDTO extends BaseDTO {

	private static final long serialVersionUID = -2792006480245303425L;
	private String resourcetype;
	private Map<String,String> filters = new HashMap<String,String>(1);
	private String program;
	
	public ModelAttributeSearchDTO(){
	}
	
	public ModelAttributeSearchDTO(String resourcetype,String program){
		this.resourcetype=String.valueOf(resourcetype);
		this.program=program;
	}

	public ModelAttributeSearchDTO(String resourcetype,String key,String value, String program) {
	    this.resourcetype=String.valueOf(resourcetype);
		this.program=program;
		addFilters(String.valueOf(key), value);
	}

	public ModelAttributeSearchDTO(String resourcetype,Map<String,String> filters){
		this.resourcetype=String.valueOf(resourcetype);
		this.filters=filters;
	}
	
	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = String.valueOf(resourcetype);
	}
	
	public Map<String, String> getFilters() {
		return filters;
	}

	public void addFilters(String key,  String value) {
		this.filters.put(key, value);
	}
	
	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

}
