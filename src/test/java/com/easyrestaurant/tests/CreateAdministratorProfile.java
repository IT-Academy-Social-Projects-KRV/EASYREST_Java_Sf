package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateAdministratorProfile {
	
	private final String email = "jacobcraig@test.com", password = "1111";

	@Test(description = "Create Administrator Profile From owner's menu")
	public void createWaiterProfile() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		String url = "http://localhost:3000";
		driver.get(url);
		
		Thread.sleep(2000);
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div/a[1]"));
		login.click();
		
		WebElement fieldEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[1]/div/div/input"));
		fieldEmail.sendKeys(email);
		
		WebElement fieldPass = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[2]/div/div/input"));
		fieldPass.sendKeys(password);
		
		WebElement logIn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[3]/div/button"));
		logIn.click();
		
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//html//div[@id='root']/header/div//button[@type='button']//div[.='J']"));
		profile.click();
		
		WebElement profileLink = driver.findElement(By.xpath("//html/body/div[2]/div[2]/ul/a"));
		profileLink.click();
		
		WebElement myRestaurantsMenu = driver.findElement(By.xpath("//html/body/div/main/div/div/div/div[2]/div/a[4]"));
		myRestaurantsMenu.click();
		
		//I need to create restaurant before do the test!
		
		WebElement showOptions = driver.findElement(By.xpath("//html/body/div/main/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/button"));
		showOptions.click();
		
		WebElement manage = driver.findElement(By.xpath("//html/body/div[2]/div[2]/ul/a"));
		manage.click();
		
		Thread.sleep(2000);
		WebElement waiterMenu = driver.findElement(By.xpath("/html//div[@id='root']//ul/a[2]//span[.='Waiters']"));
		waiterMenu.click();
			
				
		Thread.sleep(5000);
		driver.close();

	}
	
	
}
