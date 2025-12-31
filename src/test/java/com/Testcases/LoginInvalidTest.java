package com.Testcases;

import com.marsdevs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidTest extends BaseTest {

// Task No -2 Negative login
    @Test
    public void invalidLoginTest() throws Exception {
        LoginPage loginpage = new LoginPage();
        loginpage.loginWithInvalidConfig();
        Assert.assertTrue(loginpage.isErrorDisplayed(), "Error message should be displayed for invalid login");


    }
}
