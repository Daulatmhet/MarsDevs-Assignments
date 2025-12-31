package com.Testcases;

import com.marsdevs.pages.Cartpage;
import com.marsdevs.pages.LoginPage;
import com.marsdevs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class CartPageTest extends BaseTest {

    // Add / remove items from cart
    @Test
    public void addAndRemoveCartItemsTest() throws Exception {    // Login
        ProductsPage productsPage = new LoginPage().loginWithConfig();

        // Add 3 products
        Map<String, String> addedProducts = productsPage.addProductsToCart(3);

        // Assert cart count = 3
        Assert.assertEquals(productsPage.getCartCount(), 3,
                "Cart count is incorrect after adding products");

        // Go to cart
        Cartpage cartPage = productsPage.goToCart();

        // Validate product details

        // Remove 1 item
        String removedProduct = cartPage.removeFirstItem();

        Assert.assertEquals(productsPage.getCartCount(), 2,
                "Cart count did NOT update after removing product");
//        Assert.assertTrue(cartPage.validateProducts(addedProducts),
//                "Product details in cart do not match product page");
        //  Assert removed item not present
        Assert.assertFalse(cartPage.isProductPresent(removedProduct),
                "Removed product is still present in cart");
    }

    }




