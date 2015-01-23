package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.ProgramDTO;
import com.erecyclingcorps.utils.Constants;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	
	@Test(enabled = true)
	public void getCurrentUserProgramListTest() {
		user.getApplication().getProgram().setProgramName(Constants.ALL);
		Map<String, Object>  programList= userService.getCurrentUserProgramList();
		List<ProgramDTO> programDTOs = (List<ProgramDTO>)programList.get(Constants.PROGRAM_LIST);
		Assert.assertEquals(true, programDTOs.size()>0);
	}

	@Test(enabled = true)
	public void getUserProgramDataOnLoadTest(ITestContext context) {
		user.getApplication().getProgram().setProgramName(Constants.ALL);
		Map<String, Object>  programList= userService.getUserProgramDataOnLoad();
		List<ProgramDTO> programDTOs = (List<ProgramDTO>)programList.get(Constants.PROGRAM_LIST);
		Assert.assertEquals(true, programDTOs.size()>0);
		
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        user.getApplication().getProgram().setProgramName(testParams.get("program"));
		programList= userService.getUserProgramDataOnLoad();
		Assert.assertNotNull(programList);

	}
}
