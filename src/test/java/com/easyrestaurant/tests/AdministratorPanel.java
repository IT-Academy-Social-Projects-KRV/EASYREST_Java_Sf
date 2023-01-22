package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdministratorPanel {
    @Test
    public void checkAdministratorPanel() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        String url = "http://localhost:3000";
        driver.get(url);


        driver.findElement(By.cssSelector("[href=\"/log-in\"]")).click();
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("emilyfitzgerald@test.com");
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys("1");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[class*=\"UserMenu-avatar\"]")).click();
        driver.findElement(By.cssSelector("[href=\"/administrator-panel\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/button[4]/span[1]/span/span")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/button[4]/span[1]/span/span")).isDisplayed(), true);

        driver.close();


    }

}
