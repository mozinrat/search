package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.TradeOptionsDTO;

/**
 * @author parora
 **/

public class TradeOptionsServiceTest extends BaseTest {

	@Autowired
	private TradeOptionsService tradeOptionsService;

	@Test(enabled = true)
    public void getPreCompleteOptions(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        List<TradeOptionsDTO> result = tradeOptionsService.getTradeOptions(testParams.get("program"));
	    Assert.assertNotNull(result.get(0).getCode());
	    Assert.assertNotNull(result.get(0).getLabel());
	    Assert.assertNotNull(result.get(0).isMandatory());
	    Assert.assertNotNull(result.get(0).isHidden());
	    Assert.assertNotNull(result.get(0).getSortOrder());
	    Assert.assertNotNull(result.get(0).getType());
	}

}
