package com.erecyclingcorps.web.controller.v1.rest.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erecyclingcorps.dto.ModelDTO;
import com.erecyclingcorps.dto.ModelSearchDTO;
import com.erecyclingcorps.service.ApiService;
import com.erecyclingcorps.service.ModelService;
import com.erecyclingcorps.validators.ModelAttributeConvertor;

/**
 * 
 * @author bbansal
 *
 */

@RestController
@RequestMapping(value = "/api")
public class SearchModelController {

    @Autowired
    private ModelService modelService;
    @Autowired
    private ApiService apiService;

    @Resource 
    ModelAttributeConvertor modelAttributeConvertor;

    @RequestMapping(value = "/models", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public List<ModelDTO> searchModel(HttpServletRequest request) {
        ModelSearchDTO searchDTO = modelAttributeConvertor.transfoms(request.getParameterMap());
        return modelService.findModel(searchDTO);
    }

    @RequestMapping(value = "/top-models", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ModelDTO> searchTopModel(@RequestParam(defaultValue = "TELUS") String program) {
        return modelService.findTopRatedModel(program);
    }

    /**
     * Method used to get CE_APP DATA to make rest request to ce-app for model search.
     * 
     * @param program
     * @return Map<String, String>
     * @throws Exception
     */
    @RequestMapping(value = "/program/{program}/trade/credentials", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> getCEAPPDetail(@RequestParam(defaultValue = "ATT") String program) {
        return apiService.getAPIData(program);
    }

    @RequestMapping(value = "/program/{program}/banner", method = RequestMethod.GET, produces = "application/json")
    public Map<String, String> getBannerDetail(@RequestParam(defaultValue = "ATT") String program) {
        return apiService.getBannerData(program);
    }
}
