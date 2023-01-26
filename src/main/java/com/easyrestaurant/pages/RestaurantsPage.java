package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestaurantsPage extends BasePageObject {

    @FindBy(xpath = "//span[contains(text(), 'Watch Menu')]")
    List<WebElement> watchMenuSelector;
    @FindBy(css = "button[aria-label='Add to cart']")
    List<WebElement> addToCartButtonSelector;
    @FindBy(id = "client-snackbar")
    WebElement clientSnackBarSelector;
    @FindBy(css = "button[aria-label='Remove item']")
    WebElement removeItemButtonSelector;

    public RestaurantsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Click on first Watch Menu
    public RestaurantsPage clickOnFirstWatchMenu() {
        for (WebElement e : watchMenuSelector) {
            e.click();
            break;
        }
        return this;
    }

    //Click on first Add to cart button
    public RestaurantsPage clickOnFirstAddToCartButton() {
        for (WebElement e : addToCartButtonSelector) {
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
