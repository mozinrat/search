package com.erecyclingcorps.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.bean.PriorityFileUpload;
import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.utils.Constants;

public class PrioritizationUploadServiceTest extends BaseTest {

    @Autowired
    private PrioritizationUploadService prioritizationUploadService;
    
    
    @DataProvider(name = "getSampleModelFiles")
    public static Object[][] getFileName(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { testParams.get("filename") } };
    }

    @Transactional
    @Rollback(true)
    @Test(enabled = true, dataProvider="getSampleModelFiles")
    public void createValidateFile(String filename) throws IOException {
        Map<String, Object> fileResult = prioritizationUploadService.createValidateFile(getFileObject(filename));
        if ((boolean) fileResult.get("hasError")) {
            Assert.assertNotNull(fileResult.get(Constants.FILE_ERROR));
            Assert.assertTrue(((List<String>) fileResult.get(Constants.FILE_ERROR)).size() > 0);
        } else {
            prioritizationUploadService.save(getFileObject(filename).getFile().getBytes(), 
                    getFileObject(filename).getAttribute(), getFileObject(filename).getProgram(), "fs_rjivan");
            Assert.assertTrue(1==1);
        }
        prioritizationUploadService.getFile(getFileObject(filename).getAttribute(), getFileObject(filename).getProgram());
        Assert.assertNotNull(getFileObject(filename).getAttribute());
    }

    public PriorityFileUpload getFileObject(String filename) throws IOException {
        URL path = ClassLoader.getSystemResource(filename);
        if(path==null) Assert.fail();
        try {
           File f = new File(path.toURI());
           byte[] data = org.apache.commons.io.FileUtils.readFileToByteArray(f);
           MockMultipartFile file = new MockMultipartFile("content", "model.csv", "text/csv", data);
           PriorityFileUpload fileUpload = new PriorityFileUpload();
           fileUpload.setAttribute(2l);
           fileUpload.setFile(file);
           fileUpload.setProgram(3l);
           return fileUpload;
        } catch (URISyntaxException e) {
        }
        return new PriorityFileUpload();
       }

}
