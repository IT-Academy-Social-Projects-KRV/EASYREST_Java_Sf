package com.easyrestaurant.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {

	@Test(priority = 1)
	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		

		driver.manage().window().maximize();
		String url = "http://localhost:3000";
		driver.get(url);
		
		driver.close();
	}
}
