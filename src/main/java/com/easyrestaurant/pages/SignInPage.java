package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePageObject {

    private final By emailInputSelector = By.xpath("//input[@name='email']");
    private final By passwordInputSelector = By.xpath("//input[@name='password']");
    private final By submitButtonSelector = By.xpath("//button[@type='submit']");


    public SignInPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SignInPage signIn(String username, String password) {
        type(emailInputSelector, username);
        type(passwordInputSelector, password);
        click(submitButtonSelector);
        return this;
    }

    public SignInPage signIn(String username, String password, String urlToBe) {
        type(emailInputSelector, username);
        type(passwordInputSelector, password);
        click(submitButtonSelector);
        waitForUrlToBe(urlToBe);
        return this;
    }
}
