package com.erecyclingcorps.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dao.domain.ProgramCategory;

public class ProgramCategoryServiceTest extends BaseTest {

	@Autowired
	private ProgramCategoryService programCategoryService;

	
    @DataProvider(name = "findByProgramCategoryDataProvider")
    public static Object[][] findByProgramCategoryInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new Long(testParams.get("programId")), testParams.get("prioritizationCategory") } };
    }
	
	@Test(enabled = true, dataProvider="findByProgramCategoryDataProvider")
	public void findByProgramCategory(Long programId, String prioritizationCategory) {
		ProgramCategory programCategory = programCategoryService.findByProgramCategory(programId, prioritizationCategory);
		if(null!=programCategory){
			Assert.assertNotNull(programCategory.getCategory());
			Assert.assertNotNull(programCategory.getId());
			Assert.assertNotNull(programCategory.getProgram());
		}
	}
}
