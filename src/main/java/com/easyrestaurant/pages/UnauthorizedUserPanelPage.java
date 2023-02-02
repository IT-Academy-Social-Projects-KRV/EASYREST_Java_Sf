package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UnauthorizedUserPanelPage extends BasePageObject {

    @FindBy(xpath = "/html/body/div/header/div/nav/a[1]/span")
    WebElement uaUserHome;

    @FindBy(xpath = "/html/body/div/header/div/nav/a[2]/span")
    WebElement uaUserRestaurantsList;

    @FindBy(xpath = "/html/body/div/main/div/div/div[2]/a/img")
    WebElement uaUserPizza;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/a[1]/span[1]/span")
    WebElement uaUserViewAllSelector;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/a[2]/span[1]/span")
    WebElement uaUserBurgersSelector;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div[1]/div/div[2]/div/div[3]/div[2]/h6")
    WebElement uaUserPhoneNum;

    @FindBy(xpath = "//span[(text()= 'details')]/ancestor::a")
    WebElement uaUserDetailsRestaurant;

    @FindBy(xpath = "//html//div[@id='root']/main//h4[.='Bennett-Prince']")
    WebElement uaUserRestaurantName;

    /*@Find(xpath = "//*[@id=\"root\"]/main/div/div/div/div[2]/p[1]")
    */WebElement uaUserRestaurantAddress;

    public UnauthorizedUserPanelPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Click on In progress in navigation bar
    public UnauthorizedUserPanelPage clickOnRestaurantList() {
        click(uaUserRestaurantsList);
        return this;
    }


    public UnauthorizedUserPanelPage clickOnScrollDown() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)", "");
        return this;
    }

    public UnauthorizedUserPanelPage clickOnDetailsButton(){
        click(uaUserDetailsRestaurant);
        return this;
    }
}
