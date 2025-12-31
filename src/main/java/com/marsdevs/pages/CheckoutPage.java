package com.marsdevs.pages;

import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {


    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishButton = By.xpath("//button[.='Finish']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By orderSummary = By.xpath("//div[@class='summary_info']");
    private final By confirmationMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");


    public CheckoutviewPage fillCustomerDetails(
            String fname, String lname, String zip) {

        sendKeys(firstName, fname, WaitStrategy.VISIBLE, "First Name");
        sendKeys(lastName, lname, WaitStrategy.VISIBLE, "Last Name");
        sendKeys(postalCode, zip, WaitStrategy.VISIBLE, "Postal Code");

        click(continueBtn, WaitStrategy.CLICKABLE, "Continue Button");

        return new CheckoutviewPage();
    }


    // Click Continue
    public CheckoutPage clickContinue() {
        click(continueBtn, WaitStrategy.CLICKABLE, "Continue Button");
        return this;
    }


    // Validate error message
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage, WaitStrategy.VISIBLE);
    }

    // Get order summary text
    public String getOrderSummary() {
        return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, orderSummary).getText();
    }

    // Validate confirmation page
    public boolean isConfirmationDisplayed() {
        return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, confirmationMessage).isDisplayed();
    }

//    public CheckoutCompletePage finishCheckout() {
//
//        scrollAndJsClick(finishButton, WaitStrategy.CLICKABLE, "Finish Button");
//
//        return new CheckoutCompletePage();
//    }
// Get the error message text
public String getErrorMessage() {
    return ExplicitWaitFactory
            .performExplicitWait(WaitStrategy.VISIBLE, errorMessage)
            .getText();
}




    // Fill partial customer details to test form validation
    public CheckoutPage fillPartialCustomerDetails(String fname, String lname, String zip) {
        if (fname != null) sendKeys(firstName, fname, WaitStrategy.VISIBLE, "First Name");
        if (lname != null) sendKeys(lastName, lname, WaitStrategy.VISIBLE, "Last Name");
        if (zip != null) sendKeys(postalCode, zip, WaitStrategy.VISIBLE, "Postal Code");

        click(continueBtn, WaitStrategy.CLICKABLE, "Continue Button");
        return this;
    }

}





