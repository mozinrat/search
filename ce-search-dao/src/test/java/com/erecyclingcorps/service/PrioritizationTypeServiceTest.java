package com.erecyclingcorps.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dao.domain.PrioritizationType;

public class PrioritizationTypeServiceTest extends BaseTest{

	@Autowired
	private PrioritizationTypeService prioritizationTypeService;

	
    @DataProvider(name = "getPrioritizationTypeListByMetaDataProvider")
    public static Object[][] getPrioritizationTypeListByMetaInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new Long(testParams.get("programId")), new Long(testParams.get("attributeId")) } };
    }
	
	@Test(enabled = true,dataProvider="getPrioritizationTypeListByMetaDataProvider")
	public void getPrioritizationTypeListByMetaDataTest(Long programId, Long attributeId) {
		PrioritizationType prioritizationType = prioritizationTypeService.getPrioritizationTypeListByMetaData(programId,attributeId);
		if(null!=prioritizationType){
			Assert.assertNotNull(prioritizationType.getId());
			Assert.assertNotNull(prioritizationType.getPriority());
			Assert.assertNotNull(prioritizationType.getAttribute());
			Assert.assertNotNull(prioritizationType.getProgram());
		}
	}
}
