package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAdministratorProfilePage extends BasePageObject {

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
    @FindBy(xpath = "//html/body/div/main/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/button")
    WebElement showOptions;
    @FindBy(xpath = "//html/body/div[2]/div[2]/ul/a")
    WebElement manageBtn;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/ul/a[3]")
    WebElement adminMenu;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
    WebElement newAdmin;
    @FindBy(name = "name")
    WebElement regName;
    @FindBy(name = "email")
    WebElement regEmail;
    @FindBy(name = "password")
    WebElement regPass;
    @FindBy(name = "phone_number")
    WebElement regPhone;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement finishAdminProfile;

    public CreateAdministratorProfilePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public WebElement myPath() {
        String path = "//span[text()='" + administratorName + "']";
        return driver.findElement(By.xpath(path));
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
    public void showOptions() {
        showOptions.click();
    }
    public void manageBtn() {
        manageBtn.click();
    }
    public void adminMenu() {
        adminMenu.click();
    }
    public void newAdmin() {
        newAdmin.click();
    }
    public WebElement regName() {
        return regName;
    }
    public WebElement regEmail() {
        return regEmail;
    }
    public WebElement regPass() {
        return regPass;
    }
    public WebElement regPhone() {
        return regPhone;
    }
    public WebElement finishAdminProfile() {
        return finishAdminProfile;
    }

}
