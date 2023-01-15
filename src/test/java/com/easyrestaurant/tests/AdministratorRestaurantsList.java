package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdministratorRestaurantsList {


    @Test
    public void administratorSeeRestaurantsList() {
        // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "http://localhost:3000";
        driver.get(url);

        driver.findElement(By.cssSelector("[href=\"/log-in\"]")).click();


    }


}
