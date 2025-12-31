package com.marsdevs.pages;

import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cartpage extends BasePage {


    private final By cartItemNames = By.xpath("//div[@class='inventory_item_name']");
    private final By cartItemPrices = By.xpath("//div[@class='inventory_item_price']");
    private final By removeButtons = By.xpath("//button[contains(@id,'remove')]");
    private final By checkoutBtn = By.id("checkout");


    //Validate product details
    public boolean validateProducts(Map<String, String> expectedProducts) {
        //  handleAlertIfPresent();
        List<WebElement> names = DriverManager.getDriver().findElements(cartItemNames);
        List<WebElement> prices = DriverManager.getDriver().findElements(cartItemPrices);

        Map<String, String> actualProducts = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            actualProducts.put(names.get(i).getText(), prices.get(i).getText());
        }

        return actualProducts.equals(expectedProducts);
    }

    //Remove first item
    public String removeFirstItem() {
        // handleAlertIfPresent();
        List<WebElement> names = DriverManager.getDriver().findElements(cartItemNames);
        List<WebElement> removeBtns = DriverManager.getDriver().findElements(removeButtons);

        String removedProductName = names.get(0).getText();
        removeBtns.get(0).click();

        ExplicitWaitFactory.waitForElementToDisappear(
                By.xpath("//div[text()='" + removedProductName + "']")
        );
        return removedProductName;
    }

    //Verify removed product NOT present
    public boolean isProductPresent(String productName) {

        List<WebElement> names = DriverManager.getDriver().findElements(cartItemNames);

        for (WebElement name : names) {
            if (name.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public CheckoutPage goToCheckout() {
        click(checkoutBtn, WaitStrategy.CLICKABLE, "Checkout Button");
        return new CheckoutPage();

    }
}



