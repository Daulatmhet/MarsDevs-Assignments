package com.marsdevs.pages;
import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Enums.WaitStrategy;
import com.marsdevs.Reports.ExtentLogger;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementname) {

        /*
         * We want to make sure can only choose from list of predefined options
         *
         */
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
        try {
            ExtentLogger.pass(elementname + "is clicked", true);
        } catch (Exception e) {
<<<<<<< HEAD
=======
            // TODO Auto-generated catch block
>>>>>>> 129980a247db5cf38670301b50b8272bef8384e6
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {

        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value + "is entered sucessfully in" + elementname, true);
        } catch (Exception e) {
<<<<<<< HEAD
=======
            // TODO Auto-generated catch block
>>>>>>> 129980a247db5cf38670301b50b8272bef8384e6
            e.printStackTrace();
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    private void explicitWaitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    private void explicitWaitForElementToBePresent(By by) {

    }

    protected boolean isDisplayed(By by, WaitStrategy waitStrategy) {
        try {
            WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // element not found or not visible
        }

    }

    protected void handleAlertIfPresent() {
        try {
            Alert alert = DriverManager.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();   // click OK
        } catch (NoAlertPresentException e) {
            // No alert present → do nothing
        }
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("arguments[0].click();", element);
    }

    protected void scrollAndJsClick(By locator, WaitStrategy waitStrategy) {
        WebElement element =
                ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);

        scrollToElement(element);
        jsClick(element);
    }
}




