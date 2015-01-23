package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.AttributeDTO;

public class AttributeServiceTest extends BaseTest {
	@Autowired
	private AttributeService attributeService;

    @DataProvider(name = "findAttributeNameByMetaDataDataProvider")
    public static Object[][] findAttributeNameByMetaDataInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new Long(testParams.get("attributeId")), new Long(testParams.get("programId")),
                testParams.get("prioritizationCategory") } };
    }

	@Test(enabled = true, dataProvider = "findAttributeNameByMetaDataDataProvider")
	public void findAttributeNameByMetaDataTest(Long attributeId, Long programId, String prioritizationCategory) {
		List<String> attributeList = attributeService.findAttributeNameByMetaData(attributeId, programId, prioritizationCategory);
		Assert.assertNotNull(attributeList);
	}

    @DataProvider(name = "findAllAttributeByProgramDataProvider")
    public static Object[][] findAllAttributeByProgramInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new Long(testParams.get("programId")) } };
    }

	@Test(enabled = true, dataProvider = "findAllAttributeByProgramDataProvider")
	public void findAllAttributeByProgramTest(Long programId) {
		List<AttributeDTO> attributes = (List<AttributeDTO>) attributeService.findAllAttributeByProgram(programId);
		for (AttributeDTO attributeDTO : attributes) {
			Assert.assertNotNull(attributeDTO.getDescription());
			Assert.assertNotNull(attributeDTO.getId());
			Assert.assertNotNull(attributeDTO.getName());
		}
	}


    @DataProvider(name = "findNameByPKDataProvider")
    public static Object[][] findNameByPKInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new Long(testParams.get("attributeId")) } };
    }

	@Test(enabled = true, dataProvider = "findNameByPKDataProvider")
	public void findNameByPKTest(Long attributeId) {
		String attributeName = attributeService.findDescriptionByPK(attributeId);
		Assert.assertNotNull(attributeName);
	}

}
