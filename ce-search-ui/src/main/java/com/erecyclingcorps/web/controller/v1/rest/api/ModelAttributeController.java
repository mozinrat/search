package com.erecyclingcorps.web.controller.v1.rest.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erecyclingcorps.dto.DiscoverMetaDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;
import com.erecyclingcorps.service.ModelAttributeService;
import com.erecyclingcorps.validators.ModelAttributeConvertor;

@Controller
@RequestMapping(value = "/api/model-attribute")
public class ModelAttributeController {

    @Resource
    private ModelAttributeService modelAttributeService;

    @Resource 
    ModelAttributeConvertor modelAttributeConvertor;
    
    @RequestMapping(method = RequestMethod.GET,produces ="application/json")
    @ResponseBody
    public List<String> searchAttribute(HttpServletRequest request) throws FilterNotFoundException{
        ModelAttributeSearchDTO modelAttributeSearchDTO = modelAttributeConvertor.transfom(request.getParameterMap());
        return modelAttributeService.findModelAttribute(modelAttributeSearchDTO);
    }

    @RequestMapping(value = "/widgets", method = RequestMethod.GET,produces ="application/json")
    @ResponseBody
    public DiscoverMetaDTO getSearchAttribute(@RequestParam String program) throws FilterNotFoundException{
        return modelAttributeService.getSearchAttribute(program);
    }
}
