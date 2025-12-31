package com.marsdevs.pages;

import com.marsdevs.Driver.DriverManager;
import com.marsdevs.Enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ProductsPage extends BasePage {

    private final By productsTitle = By.xpath("//span[text()='Products']");
    public final By Click_Hamburgermenu = By.xpath("//div[@class='bm-burger-button']");
    public final By clickon_logout = By.xpath("//a[.='Logout']");
    public final By sortDropdown = By.xpath("//select[@class='product_sort_container']");
    public final By ProductsNames = By.xpath("//div[@class='inventory_item']");
    public final By productPrices = By.xpath("//div[@class='inventory_item_price']");
    private final By addToCartButtons = By.xpath("//button[contains(@id,'add-to-cart')]");
    private final By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private final By checkoutBtn = By.id("checkout");


    public boolean isProductsPageDisplayed() {
        return ExplicitWaitFactory
                .performExplicitWait(WaitStrategy.VISIBLE, productsTitle)
                .isDisplayed();

    }


    public String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public ProductsPage Hamburgermenuclick() {

        click(Click_Hamburgermenu, WaitStrategy.CLICKABLE, "Hamburger Menu");
        return this;
    }

    public LoginPage clickLogout() {
        click(clickon_logout, WaitStrategy.CLICKABLE, "Logout Button");
        return new LoginPage(); // after logout, user goes to login page
    }

    public void sortProducts(String sortOption) {
        WebElement dropdown = ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, sortDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(sortOption);
    }


    // -------- SORT ACTION --------
    public ProductsPage sortBy(String visibleText) {
        WebElement dropdown = ExplicitWaitFactory.performExplicitWait(
                WaitStrategy.CLICKABLE, sortDropdown);

        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
        return this;
    }

    public boolean isPriceSortedLowToHigh() {
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : DriverManager.getDriver().findElements(productPrices)) {
            actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        return actualPrices.equals(sortedPrices);
    }

    // -------- VALIDATION: NAME A → Z --------
    public boolean isNameSortedAZ() {
        List<String> actualNames = new ArrayList<>();

        for (WebElement name : DriverManager.getDriver().findElements(ProductsNames)) {
            actualNames.add(name.getText());
        }

        List<String> sortedNames = new ArrayList<>(actualNames);
        Collections.sort(sortedNames);

        return actualNames.equals(sortedNames);
    }
// Click on Add a product**

    public Map<String, String> addProductsToCart(int count) {

        List<WebElement> names = DriverManager.getDriver().findElements(ProductsNames);
        List<WebElement> prices = DriverManager.getDriver().findElements(productPrices);
        List<WebElement> buttons = DriverManager.getDriver().findElements(addToCartButtons);

        Map<String, String> productMap = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String name = names.get(i).getText();
            String price = prices.get(i).getText();

            buttons.get(i).click();

            productMap.put(name, price);
        }
        return productMap;
    }
// Get a Cart
    public int getCartCount() {
        return Integer.parseInt(
                ExplicitWaitFactory.performExplicitWait(
                        WaitStrategy.VISIBLE, cartBadge).getText());
    }

    public Cartpage goToCart() {
        click(cartIcon, WaitStrategy.CLICKABLE, "Cart Icon");
        return new Cartpage();
    }

    public CheckoutPage goToCheckout() {
        click(checkoutBtn, WaitStrategy.CLICKABLE, "Checkout Button");
        return new CheckoutPage();
    }
}




