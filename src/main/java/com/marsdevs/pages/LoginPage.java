package com.marsdevs.pages;


import Utils.PropertyUtil;
import com.marsdevs.Enums.ConfigProperies;
import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public final By textbox_username = By.xpath("//input[@id='user-name']");
    public final By textbox_password = By.xpath("//input[@id='password']");
    public final By Sign_inBtn = By.xpath("//input[@id='login-button']");
    public final By errorMessage = By.xpath("//h3[@data-test='error']");


    public ProductsPage loginWithConfig() throws Exception {
        sendKeys(textbox_username,
                PropertyUtil.get(ConfigProperies.USERNAME),
                WaitStrategy.VISIBLE,
                "Username");
        sendKeys(textbox_password,
                PropertyUtil.get(ConfigProperies.PASSWORD),
                WaitStrategy.VISIBLE,
                "Password");

        click(Sign_inBtn,
                WaitStrategy.CLICKABLE,
                "Login Button");

        return new ProductsPage();
    }

    public LoginPage loginWithInvalidConfig() throws Exception {
        sendKeys(textbox_username,
                PropertyUtil.get(ConfigProperies.INVALID_USERNAME),
                WaitStrategy.VISIBLE,
                "Username");
        sendKeys(textbox_password,
                PropertyUtil.get(ConfigProperies.INVALID_PASSWORD),
                WaitStrategy.VISIBLE,
                "Password");
        click(Sign_inBtn, WaitStrategy.CLICKABLE, "Login Button");
        return this; // stay on LoginPage
    }


        public String getTitle(){
        return getPageTitle();
    }


    // Check if error message is displayed
    public boolean isErrorDisplayed() {
        try {
            return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    }




