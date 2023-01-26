package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

    private final By restaurantsListButtonSelector = By.cssSelector("a[href='/restaurants']");
    private final By signInSelector = By.xpath("//span[text()='Sign In']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public RestaurantsPage clickOnRestaurantList() {
        click(restaurantsListButtonSelector);
        return new RestaurantsPage(driver, log);
    }

    public HomePage clickOnSignIn() {
        click(signInSelector);
        return this;
    }

    public HomePage navigateToHomePage() {
        navigateTo(URL);
        return this;
    }
}
