package com.erecyclingcorps.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erecyclingcorps.dao.BaseTest;
import com.erecyclingcorps.dto.EmailDetailDTO;

/**
 * @author parora
 **/

public class SendEmailServiceTest extends BaseTest {

    @Autowired
    private EmailFacade sendEmailService;


    @DataProvider(name = "getEmailDataDP")
    public static Object[][] sampleEmailInput(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        return new Object[][] { { new EmailDetailDTO(testParams.get("senderAddress"),
                testParams.get("recipientAddress"), testParams.get("subject"), testParams.get("message"),
                testParams.get("program")) } };
    }

    @Test(enabled = true, dataProvider = "getEmailDataDP")
    public void sendEmailTest(EmailDetailDTO email) {
        sendEmailService.doSendEmail(email);
        boolean sent=false;
        try {
            Thread.sleep(10000);
            sent=true;
        } catch (InterruptedException e) {
            Assert.fail();
        }
        Assert.assertTrue(sent);
    }

    @Test(enabled = true)
    public void getRetryMail(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        List<EmailDetailDTO> result = sendEmailService.getRetryEmails(testParams.get("program"));
        Assert.assertNotNull(result);
    }

    @Test(enabled = true)
    public void resendEmail(ITestContext context) {
        Map<String, String> testParams = context.getCurrentXmlTest().getAllParameters();
        List<EmailDetailDTO> result = sendEmailService.getRetryEmails(testParams.get("program"));
        for (EmailDetailDTO email : result) {
            sendEmailService.retryEmailSending(email);
        }
        Assert.assertNotNull(result);
    }
}
