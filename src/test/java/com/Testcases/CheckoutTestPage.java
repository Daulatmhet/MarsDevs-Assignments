package com.Testcases;

import com.marsdevs.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class CheckoutTestPage extends BaseTest {

    //  Checkout Flow
    //6. Successful checkout

    @Test
    public void successfulCheckoutTest() throws Exception {

        ProductsPage productsPage = new LoginPage().loginWithConfig();
        Map<String, String> products =
                productsPage.addProductsToCart(3);

        Cartpage cartPage = productsPage.goToCart();
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        CheckoutviewPage overviewPage =
                checkoutPage.fillCustomerDetails("John", "Doe", "411001");

        Assert.assertTrue(
                overviewPage.validateItemCount(3),
                "Item count mismatch");
        double expectedTotal = products.values().stream()
                .map(p -> p.replace("$", ""))
                .mapToDouble(Double::parseDouble)
                .sum();

//        Assert.assertTrue(
//                overviewPage.validateTotalPrice(expectedTotal),
//                "Total price mismatch");

        CheckoutCompletePage completePage =
                overviewPage.finishCheckout();


        Assert.assertTrue(
                completePage.isConfirmationDisplayed(),
                "Confirmation page not displayed");
    }



    // This Task no 7 Achived with JSON DATA


        @DataProvider(name = "checkoutFormData")
        public Object[][] checkoutFormData() {
            return new Object[][] {
                    {null, "Doe", "12345", "Error: First Name is required"}
            };
        }


    // Task No 7 Validation Form validation
    // Form validation

    @Test(dataProvider = "checkoutFormData")
    public void checkoutFormValidationTest(String firstName, String lastName, String postalCode, String expectedError) throws Exception {
        ProductsPage productsPage = new LoginPage().loginWithConfig();
        productsPage.addProductsToCart(1);
        Cartpage cartPage = productsPage.goToCart();
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        // Leave First Name blank to trigger error
        checkoutPage.fillPartialCustomerDetails(firstName, lastName, postalCode);

    Assert.assertTrue(checkoutPage.isErrorDisplayed(), "Error message not displayed");
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");
    }
    }




