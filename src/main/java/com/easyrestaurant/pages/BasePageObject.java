package com.easyrestaurant.pages;

import com.easyrestaurant.utils.Defaults;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject extends Defaults {
    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected void click(By locator) {
        waitForPresenceOfElement(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        waitForPresenceOfElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected WebElement find(By selector) {
        waitForPresenceOfElement(selector);
        return driver.findElement(selector);
    }

    protected List<WebElement> findAll(By selector) {
        waitForPresenceOfElement(selector);
        return driver.findElements(selector);
    }

    protected String getText(By selector) {
        waitForPresenceOfElement(selector);
        return driver.findElement(selector).getText();
    }

    protected void waitForPresenceOfElement(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }


    protected void waitForUrlToBe(String urlToBe) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(urlToBe));
    }

}
