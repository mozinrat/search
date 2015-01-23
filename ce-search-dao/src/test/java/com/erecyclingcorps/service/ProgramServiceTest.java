package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.ProgramDTO;

public class ProgramServiceTest extends BaseTest {
	@Autowired
	private ProgramService programService;

	@Test(enabled = true)
	public void getAllProgramsTest() {
		List programs = (List) programService.getAllPrograms();
		Assert.assertNotNull(programs);
		Assert.assertTrue(!programs.isEmpty());
	}

    @Test(enabled = true)
    public void findCurrentUserProgram(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        ProgramDTO p = programService.findCurrentUserProgram(testParams.get("user"));
        Assert.assertNotNull(p);
    }
}
