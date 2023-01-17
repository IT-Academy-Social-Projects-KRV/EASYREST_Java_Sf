package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdministratorRestaurantsList {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void loginToWebSite() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String url = "http://localhost:3000";
        driver.get(url);
        driver.findElement(By.cssSelector("[href=\"/log-in\"]")).click();
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("emilyfitzgerald@test.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("1");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    @AfterClass
    public void closeApp() {
        driver.close();
    }

    @Test
    public void administratorSeeRestaurantsList() {
        driver.findElement(By.cssSelector("[href=\"/restaurants\"]")).click();
        driver.findElement(By.cssSelector("[href=\"/?tag=pizza\"]")).isDisplayed();
    }
}
