package com.marsdevs.pages;

import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutviewPage extends BasePage{
    private final By itemNames =
            By.xpath("//div[@class='inventory_item_name']");
    private final By itemPrices =
            By.xpath("//div[@class='inventory_item_price']");
    private final By totalLabel =
            By.xpath("//div[@class='summary_total_label']");
    private final By finishBtn = By.id("finish");

    // Validate items count
    public boolean validateItemCount(int expectedCount) {
        List<WebElement> items =
                DriverManager.getDriver().findElements(itemNames);
        return items.size() == expectedCount;
    }


    // Validate total price
    public boolean validateTotalPrice(double expectedTotal) {
        String totalText =
                ExplicitWaitFactory.performExplicitWait(
                        WaitStrategy.VISIBLE, totalLabel).getText();

        double actualTotal =
                Double.parseDouble(totalText.replace("Total: $", "").trim());

        return Double.compare(actualTotal, expectedTotal) == 0;
    }


    private final By finishButton = By.id("finish");

    public CheckoutCompletePage finishCheckout() {

        scrollAndJsClick(finishButton, WaitStrategy.PRESENCE);

        return new CheckoutCompletePage();
    }





}



