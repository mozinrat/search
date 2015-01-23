package com.erecyclingcorps.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.erecyclingcorps.dao.ModelAttributeDAO;
import com.erecyclingcorps.dto.DiscoverMetaDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;
import com.erecyclingcorps.service.LabelConstantService;
import com.erecyclingcorps.service.ModelAttributeService;

@Service("modelAttributeService")
public class ModelAttributeServiceImpl implements ModelAttributeService {

    @Resource
    ModelAttributeDAO modelAttributeDAO;
    
    @Resource
    LabelConstantService labelConstantService;

    @Override
    @Cacheable(value="widgetcache",key="'cesearch.findModelAttribute-'+#modelAttributeSearchDTO.getResourcetype()",condition="#modelAttributeSearchDTO.getFilters().size()==0")
    public List<String> findModelAttribute(ModelAttributeSearchDTO modelAttributeSearchDTO) throws FilterNotFoundException{
        return  modelAttributeDAO.getSearchWidgetValues(modelAttributeSearchDTO);
    }

    @Cacheable(value="searchwidgetcache",key="'cesearch.getSearchAttribute-'+#program")
    public DiscoverMetaDTO getSearchAttribute(String program) {
        DiscoverMetaDTO discoverByMeta = new DiscoverMetaDTO(); 
        discoverByMeta.setHeader(labelConstantService.findLabelConstantByCode(DiscoverByMeta.DISCOVER_BY_META_HEADER.toString()));
        discoverByMeta.setButtonLabel(labelConstantService.findLabelConstantByCode(DiscoverByMeta.DISCOVER_BY_META_BUTTON.toString()));
        discoverByMeta.setMeta(modelAttributeDAO.getSearchWidgets(program));
        discoverByMeta.setResultTitle(labelConstantService.findLabelConstantByCode(DiscoverByMeta.DISCOVER_BY_META_RESULT.toString()));
        return discoverByMeta ; 
    }
    
    enum DiscoverByMeta{
        DISCOVER_BY_META_HEADER,
        DISCOVER_BY_META_BUTTON,
        DISCOVER_BY_META_RESULT;
    }
}
