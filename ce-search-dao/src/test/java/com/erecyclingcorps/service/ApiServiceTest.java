package com.erecyclingcorps.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.ContactUsDTO;
import com.erecyclingcorps.utils.Constants;

/**
 * @author parora
 **/

public class ApiServiceTest extends BaseTest {

	@Autowired
	private ApiService apiService;

	@Autowired
	private RequestHelpService requestHelpService;

    @DataProvider(name = "getAPIDataDP")
    public static Object[][] findAllAttributeByProgramInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { testParams.get("program") } };
    }

	@Test(enabled = true, dataProvider = "getAPIDataDP")
	public void getAPIData(String program) {
		Map<String, String> apiData = apiService.getAPIData(program);
		Assert.assertNotNull(apiData);
		Assert.assertTrue(apiData.size() == 2);
		Assert.assertNotNull(apiData.get(Constants.URL));
		Assert.assertNotNull(apiData.get(Constants.TOKEN));
	}
	
	@Test(enabled = true, dataProvider = "getAPIDataDP")
    public void getBannerData(String program) {
        Map<String, String> apiData = apiService.getBannerData(program);
        Assert.assertNotNull(apiData);
        Assert.assertTrue(apiData.size() >0);
    }
	
	@Test(enabled = true, dataProvider = "getAPIDataDP")
    public void getContactUsDetails(String program) {
        ContactUsDTO contactUsData = requestHelpService.getContactUsEmailWidgets(program);
        Assert.assertNotNull(contactUsData);
        Assert.assertTrue(StringUtils.isNotBlank(contactUsData.getButton()));
        Assert.assertTrue(!contactUsData.getHeader().values().contains(null) || contactUsData.getHeader().values().contains(""));
        Assert.assertTrue(!contactUsData.getComments().values().contains(null) || contactUsData.getComments().values().contains(""));
        Assert.assertTrue(!contactUsData.getQuestions().values().contains(null) || contactUsData.getQuestions().values().contains(""));
    }
	
	

}
