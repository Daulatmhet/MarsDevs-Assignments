package com.Testcases;

import com.marsdevs.pages.LoginPage;
import com.marsdevs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Test
public class ProductPageTest extends BaseTest {

// 41.1 .3. Logout
    public void logoutTest() throws Exception {

        LoginPage loginPage = new LoginPage();
        ProductsPage productsPage = loginPage.loginWithConfig();

        LoginPage logoutPage = productsPage.Hamburgermenuclick().clickLogout();
        Assert.assertEquals(logoutPage.getTitle(), "Swag Labs");

        //
    }

    // TAsk No 4.2
    //Product Browsing & Cart
 //Product sorting & filtering
    @Test
    public void verifyProductSorting() throws Exception {

        // Login
        ProductsPage productsPage = new LoginPage().loginWithConfig();

        // -------- NAME A TO Z --------
        productsPage.sortBy("Name (A to Z)");
        assertTrue(productsPage.isNameSortedAZ(),
                "Products are NOT sorted by Name A to Z");

        // -------- PRICE LOW TO HIGH --------
        productsPage.sortBy("Price (low to high)");
        assertTrue(productsPage.isPriceSortedLowToHigh(),
                " Products are NOT sorted by Price Low to High");



    }


}


