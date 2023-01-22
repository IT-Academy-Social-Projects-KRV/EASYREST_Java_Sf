package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AdministratorCanSeeSubpages {

    @Test
    public void administratorCanSeeFourSubpages() {
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
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Waiting for confirm\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Accepted\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Assigned waiter\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()=\"Waiters\"]")).isDisplayed());
        driver.close();


    }

}
