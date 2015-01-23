package com.erecyclingcorps.dao;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author rverma
 **/

public class UserDAOTest extends BaseTest {

    @Autowired
    UserDAO userDao;    

    @Test(enabled = true)
    public void getAuthenticatedUser() {
        user = userDao.findByUserName("fs_rjivan");
        Assert.assertNotNull(user);    
    }
}
