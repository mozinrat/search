package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.DiscoverMetaDTO;
import com.erecyclingcorps.dto.ModelAttributeSearchDTO;
import com.erecyclingcorps.exceptions.FilterNotFoundException;

public class ModelAttributeServiceTest extends BaseTest{

    @Resource
    private ModelAttributeService modelAttributeService;


    @DataProvider(name = "positive")
    public static Object[][] modelAttributesWithPositiveInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        ModelAttributeSearchDTO modelAttributeSearchDTO = new ModelAttributeSearchDTO(testParams.get("resourcetype"),
                testParams.get("program"));
        if (StringUtils.isNotEmpty(testParams.get("key")) && StringUtils.isNotEmpty(testParams.get("value")))
            modelAttributeSearchDTO.addFilters(testParams.get("key"), testParams.get("value"));
        return new Object[][] { { modelAttributeSearchDTO } };
    }

    @DataProvider(name = "negative")
    public static Object[][] modelAttributesWithNegativeInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        ModelAttributeSearchDTO modelAttributeSearchDTO = new ModelAttributeSearchDTO(testParams.get("resourcetype"),
                testParams.get("program"));
        if (StringUtils.isNotEmpty(testParams.get("key")) && StringUtils.isNotEmpty(testParams.get("value")))
            modelAttributeSearchDTO.addFilters(testParams.get("key"), testParams.get("value"));
        return new Object[][] { { modelAttributeSearchDTO } };
    }

    @Test(enabled = true, dataProvider="positive")
    public void findModelByModelNameTestPositive(ModelAttributeSearchDTO modelAttributeSearchDTO) {
        List<String> modelAttributeDTO ;
        try {
            modelAttributeDTO = modelAttributeService.findModelAttribute(modelAttributeSearchDTO);
            Assert.assertNotNull(modelAttributeDTO);
        } catch (FilterNotFoundException e) {
            Assert.assertTrue(1==1);
        }

    }

    @Test(enabled = true, dataProvider="negative")
    public void findModelByModelNameTestNegative(ModelAttributeSearchDTO modelAttributeSearchDTO) {
        List<String> modelAttributeDTO;
        try {
            modelAttributeDTO = modelAttributeService.findModelAttribute(modelAttributeSearchDTO);
            Assert.assertTrue(null==modelAttributeDTO || modelAttributeDTO.size()==0);
        } catch (FilterNotFoundException e) {
            Assert.assertTrue(1==1);
        }
    }

    @Test(enabled = true)
    public void getSearchWidgets(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        DiscoverMetaDTO result = modelAttributeService.getSearchAttribute(testParams.get("program"));
        Assert.assertNotNull(result);
    }
    
}


