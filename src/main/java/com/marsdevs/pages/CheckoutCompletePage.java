package com.marsdevs.pages;

import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class CheckoutCompletePage  extends BasePage{


    private final By confirmationMessage =
            By.xpath("//h2[text()='Thank you for your order!']");

    public boolean isConfirmationDisplayed() {
        return ExplicitWaitFactory
                .performExplicitWait(WaitStrategy.VISIBLE, confirmationMessage)
                .isDisplayed();
    }
}

