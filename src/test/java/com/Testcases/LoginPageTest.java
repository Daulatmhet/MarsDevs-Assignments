package com.Testcases;

import com.marsdevs.pages.LoginPage;
import com.marsdevs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    // 4.1 1.Successful login
@Test
    public void VerifyUI() throws Exception {
        //ExplicitWaitFactory.waitForPageToLoad();

       // ExplicitWaitFactory.

        LoginPage page = new LoginPage();

        ProductsPage productpage = page.loginWithConfig();

    Assert.assertTrue(
            productpage.getCurrentUrl().contains("inventory"),
            "User did not navigate to Products page"
    );


    Assert.assertTrue(
            productpage.isProductsPageDisplayed(),
            "Products page unique element is not visible"
    );

    }




}



