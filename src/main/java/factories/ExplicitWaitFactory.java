package factories;

import Constants.FramworkConstants;
import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

//        WebElement element = null;
//        if (waitStrategy == waitStrategy.CLICKABLE) {
//
//            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
//                    .until(ExpectedConditions.elementToBeClickable(by));
//        } else if (waitStrategy == WaitStrategy.PRESENCE) {
//            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
//                    .until(ExpectedConditions.elementToBeClickable(by));
//
//        } else if (waitStrategy == WaitStrategy.VISIBLE) {
//            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FramworkConstants.getExplicitwait()))
//                    .until(ExpectedConditions.elementToBeClickable(by));
//
//        } else if (waitStrategy == WaitStrategy.NONE) {
//            element = DriverManager.getDriver().findElement(by);
//
//        }
//        return element;
//
//    }

    WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(),
                    Duration.ofSeconds(FramworkConstants.getExplicitwait()));

    switch (waitStrategy) {

        case CLICKABLE:
            return wait.until(ExpectedConditions.elementToBeClickable(by));

        case VISIBLE:
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        case PRESENCE:
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));

        case NONE:
        default:
            return DriverManager.getDriver().findElement(by);
    }
}



    public static void waitForElementToDisappear(By by) {
        WebDriverWait wait =
                new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}



//    public static void waitForPageToLoad(WebDriver driver) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//
//            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
//                    .executeScript("return document.readyState").equals("complete"));
//
//            wait.until(ExpectedConditions.urlContains("Login"));
//
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))); // Change locator if needed
//
//            System.out.println("Page fully loaded.");
//
//        } catch (Exception e) {
//            System.out.println("Page load timed out or failed: " + e.getMessage());
//            throw new RuntimeException("Page load failed", e);
//        }
//    }
//}
//

