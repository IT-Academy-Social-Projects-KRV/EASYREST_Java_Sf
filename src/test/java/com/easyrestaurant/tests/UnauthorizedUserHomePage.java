package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnauthorizedUserHomePage {
	
	@Test
	public void Testing() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		sleep(3000);
		driver.manage().window().maximize();
		
		String url = "http://localhost:3000";
		driver.get(url);
		
		//Pizza option
		WebElement pizza = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div[2]/a"));
		String pizzaActual = "Pizza";
			
		Assert.assertEquals(pizzaActual, pizza.getText());
			
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		sleep(3000);
		
		js.executeScript("window.scrollBy(0,1000)", "");
	
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