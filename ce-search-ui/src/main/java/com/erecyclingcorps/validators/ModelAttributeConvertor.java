package com.erecyclingcorps.validators;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;

@Component
public class ModelAttributeConvertor {

    public static final String RESOURCE_ATTRIBUTE = "resourcetype";
    public static final String PROGRAM_ATTRIBUTE = "program";
    public static final String SEARCHTEXT_ATTRIBUTE = "searchText";
    public static final String BATCHSIZE_ATTRIBUTE = "batchSize";
    public static final String STARTAT_ATTRIBUTE = "startAt";

    public ModelAttributeSearchDTO transfom(Map<String,String[]> request){
        ModelAttributeSearchDTO result = new ModelAttributeSearchDTO();
        Iterator<Entry<String, String[]>> entries = request.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, String[]> thisEntry = (Entry<String, String[]>) entries.next();
            String key = (String)thisEntry.getKey();
            String value = ((String[])thisEntry.getValue())[0];

            if(RESOURCE_ATTRIBUTE.equalsIgnoreCase(key)) {
                result.setResourcetype(value);
            } else if(PROGRAM_ATTRIBUTE.equalsIgnoreCase(key)){ 
                result.setProgram(value);
            } else {
                result.addFilters(key.toUpperCase(),value );              
            }
        }
        return result;
    }

    public ModelSearchDTO transfoms(Map<String,String[]> request){
        ModelSearchDTO result = new ModelSearchDTO();
        Iterator<Entry<String, String[]>> entries = request.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, String[]> thisEntry = (Entry<String, String[]>) entries.next();
            String key = (String)thisEntry.getKey();
            String value = ((String[])thisEntry.getValue())[0];

            if(SEARCHTEXT_ATTRIBUTE.equalsIgnoreCase(key)) {
                result.setSearchText(value);
            } else if(PROGRAM_ATTRIBUTE.equalsIgnoreCase(key)) { 
                result.setProgram(value);
            } else if(BATCHSIZE_ATTRIBUTE.equalsIgnoreCase(key)) { 
                result.setBatchSize(value);
            } else if(STARTAT_ATTRIBUTE.equalsIgnoreCase(key)) { 
                result.setStartAt(value);
            } else{
                result.addFilters(key.toUpperCase(),value );
            }
        }
        return result;
    }
}
