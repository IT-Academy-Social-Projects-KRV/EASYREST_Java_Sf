package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRestaurantFromOwnerPage extends BasePageObject {

    private final static String administratorName = "Zaio Baio",
            administratorEmail = "zaio@bg.eu",
            securePass = "Neznamtaziparola2",
            phoneNumber = "0872142767";
    @FindBy(xpath = "//*[@id=\"root\"]/header/div/div/div/a[1]")
    WebElement login;
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[2]/form/div/div[1]/div/div/input")
    WebElement fieldEmail;
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[2]/form/div/div[2]/div/div/input")
    WebElement fieldPass;
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[2]/form/div/div[3]/div/button")
    WebElement logIn;
    @FindBy(xpath = "//html//div[@id='root']/header/div//button[@type='button']//div[.='J']")
    WebElement profile;
    @FindBy(xpath = "//html/body/div[2]/div[2]/ul/a")
    WebElement profileLink;
    @FindBy(xpath = "//html/body/div/main/div/div/div/div[2]/div/a[4]")
    WebElement myRestaurantsMenu;
    @FindBy(xpath = "//button[@title='Add restaurant']")
    WebElement addRestaurant;
    @FindBy(xpath = "//input[@name='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@name='address']")
    WebElement inputAddress;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    public CreateRestaurantFromOwnerPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String adminName() {
        return administratorName;
    }
    public String adminEmail() {
        return administratorEmail;
    }
    public String adminPass() {
        return securePass;
    }
    public String adminPhone() {
        return phoneNumber;
    }
    public void login() {
        login.click();
    }
    public WebElement fieldEmail() {
        return fieldEmail;
    }
    public WebElement fieldPass() {
        return fieldPass;
    }
    public void logIn() {
        logIn.click();
    }
    public void profile() {
        profile.click();
    }
    public void profileLink() {
        profileLink.click();
    }
    public void myRestaurantsMenu() {
        myRestaurantsMenu.click();
    }
    public void addRestaurants() {
        addRestaurant.click();
    }
    public void addName() {
        inputName.sendKeys("My new rest");
    }
    public void addAddress() {
        inputAddress.sendKeys("Bulgaria, Sofia");
    }
    public void submitRestaurantsRecord() {
        btnSubmit.click();
    }

}
