package com.erecyclingcorps.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import liquibase.util.csv.opencsv.bean.HeaderColumnNameMappingStrategy;

import org.apache.commons.lang.StringUtils;

public class CustomHeaderColumnNameMappingStrategy extends HeaderColumnNameMappingStrategy {

	private List<String> invalidHeadersList = new ArrayList<String>(5);
	private List<String> validHeadersList = new ArrayList<String>(5);

	protected PropertyDescriptor findDescriptor(String name) throws IntrospectionException {
		if (null == descriptors){
			descriptors = loadDescriptors(getType());
		}
		for (int i = 0; i < descriptors.length; i++) {
			PropertyDescriptor desc = descriptors[i];
			if (matches(name, desc)) {
				validHeadersList.add(name);
				return desc;
			}
		}
		invalidHeadersList.add(name);
		return null;
	}

	protected boolean matches(String name, PropertyDescriptor desc) {
		return (StringUtils.containsIgnoreCase(name, Constants.CUSTOM_ATTRIBUTE) && desc.getName().equalsIgnoreCase(Constants.CUSTOM_ATTRIBUTES))
				|| desc.getName().equalsIgnoreCase(name.replaceAll(" ", ""));
	}

	/**
	 * @param col
	 * @return
	 */
	public String findColumn(int col) {
		return getColumnName(col);
	}

    public List<String> getInvalidHeadersList() {
        return invalidHeadersList;
    }

    public List<String> getValidHeadersList() {
        return validHeadersList;
    }

}
