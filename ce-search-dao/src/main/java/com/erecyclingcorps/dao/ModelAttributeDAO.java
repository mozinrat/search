package com.erecyclingcorps.dao;

import java.util.List;

import com.erecyclingcorps.dto.ModelAttributeDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;

public interface ModelAttributeDAO {
    
    public List<String> getSearchWidgetValues(ModelAttributeSearchDTO searchDTO) throws FilterNotFoundException;

    public List<ModelAttributeDTO> getSearchWidgets(String program);
}
