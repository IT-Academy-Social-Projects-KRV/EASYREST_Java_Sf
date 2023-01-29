package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnauthorizedUserRestaurantList {
	
	@Test
	public void Tested() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		sleep(3000);
		driver.manage().window().maximize();
		
		String url = "http://localhost:3000/restaurants";
		driver.get(url);
		
		//VIEW ALL MENU
		WebElement viewAll = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/a[1]/span[1]/span"));
		String actualViewAll = "VIEW ALL";
		
		//BURGERS MENU
		WebElement burgers = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/a[2]/span[1]/span"));
		String actualBurgers = "BURGERS";	
		
		//Phone number.
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[1]/div/div[2]/div/div[3]/div[2]/h6"));
		String actualPhone = "Phone: +380362100001";
		
		Assert.assertEquals(actualViewAll, viewAll.getText());
		Assert.assertEquals(actualBurgers, burgers.getText());
		Assert.assertEquals(actualPhone, phone.getText());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		sleep(3000);
		
		js.executeScript("window.scrollBy(0,500)", "");
		
		
		
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
