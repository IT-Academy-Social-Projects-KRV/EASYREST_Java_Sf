package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestaurantsPage extends BasePageObject {

    private final By watchMenuSelector = By.xpath("//span[contains(text(), 'Watch Menu')]");
    private final By addToCartButtonSelector = By.cssSelector("button[aria-label='Add to cart']");
    private final By clientSnackBarSelector = By.id("client-snackbar");
    private final By removeItemButtonSelector = By.cssSelector("button[aria-label='Remove item']");

    public RestaurantsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Click on first Watch Menu
    public RestaurantsPage clickOnFirstWatchMenu() {
        var allWatchMenu = findAll(watchMenuSelector);
        for (WebElement e : allWatchMenu) {
            e.click();
            break;
        }
        return this;
    }

    //Click on first Add to cart button
    public RestaurantsPage clickOnFirstAddToCartButton() {
        var allAddToCartButtons = findAll(addToCartButtonSelector);
        for (WebElement e : allAddToCartButtons) {
            e.click();
            break;
        }
        return this;
    }

    //Get client snackbar text
    public String getClientSnackBarText() {
        return getText(clientSnackBarSelector);
    }

    //Click on Remove item from cart button
    public RestaurantsPage clickRemoveItemFromCart() {
        click(removeItemButtonSelector);
        return this;
    }


}
