package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AsAdmin_ICan_UnbanModerator {

	@Test
	public void test() {

		System.setProperty("web-driver.chrome.driver",
				"src/main/resources/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://localhost:3000";
		driver.get(url);

		WebElement signInButton = driver.findElement(By.xpath("//div[@id='root']/header//div[@class='UserMenu-root-109']/div/a[1]/span[@class='MuiButton-label-81']"));
		signInButton.click();

		WebElement emailElement = driver.findElement(By.name("email"));
		emailElement.sendKeys("steveadmin@test.com");

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys("1");

		WebElement logInButton = driver.findElement(By.xpath("/html//div[@id='root']/main//form//button[@type='submit']/span[@class='MuiButton-label-81']"));
		logInButton.click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebElement moderatorButton = driver.findElement(By.xpath("/html/body/div/div/ul/a[3]/div[2]/span"));
		moderatorButton.click();

		WebElement statusMsg = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/table/tbody/tr[1]/td[4]/p"));
		WebElement statusModeratorButton = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/table/tbody/tr[1]/td[5]/button"));

		if (statusMsg.getText().equals("Banned")){
			statusModeratorButton.click();
			statusMsg = driver.findElement(By.xpath("/html/body/div/div/main/div[2]/table/tbody/tr[1]/td[4]/p"));
		}

		String expectedActivityMsg = "Active";
		Assert.assertEquals(expectedActivityMsg, statusMsg.getText());

		driver.close();
	}
}
