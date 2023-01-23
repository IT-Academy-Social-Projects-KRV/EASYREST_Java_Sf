package com.easyrestaurant.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateAdministratorProfile {
	
	WebDriver driver;
	static LoadProperties properties = new LoadProperties();
	private final static String administratorName = "Zaio Baio",
			administratorEmail = "zaio@bg.eu",
			securePass = "Neznamtaziparola2",
			phoneNumber = "0872142767";

	@Test(description = "Create Administrator Profile From owner's menu",
			priority = 1)
	public void createWaiterProfile() throws InterruptedException {
		//Load username and password from config.properties
		properties.loadProperties();
		final String email = properties.userEmail, password = properties.userPassword;
			
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url = "http://localhost:3000";
		driver.get(url);
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div/a[1]"));
		login.click();
		WebElement fieldEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[1]/div/div/input"));
		fieldEmail.sendKeys(email);
		WebElement fieldPass = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[2]/div/div/input"));
		fieldPass.sendKeys(password);
		WebElement logIn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[3]/div/button"));
		logIn.click();
		WebElement profile = driver.findElement(By.xpath("//html//div[@id='root']/header/div//button[@type='button']//div[.='J']"));
		profile.click();
		WebElement profileLink = driver.findElement(By.xpath("//html/body/div[2]/div[2]/ul/a"));
		profileLink.click();
		WebElement myRestaurantsMenu = driver.findElement(By.xpath("//html/body/div/main/div/div/div/div[2]/div/a[4]"));
		myRestaurantsMenu.click();
		
		//I need to create restaurant before launch next step!
		WebElement showOptions = driver.findElement(By.xpath("//html/body/div/main/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/button"));
		showOptions.click();
		WebElement manage = driver.findElement(By.xpath("//html/body/div[2]/div[2]/ul/a"));
		manage.click();
		WebElement adminMenu = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/ul/a[3]"));
		adminMenu.click();
		WebElement newAdmin = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/button"));
		newAdmin.click();
		
		WebElement regName = driver.findElement(By.name("name"));		
		WebElement regEmail = driver.findElement(By.name("email"));
		WebElement regPass = driver.findElement(By.name("password"));
		WebElement regPhone = driver.findElement(By.name("phone_number"));
		WebElement finishAdminProfile = driver.findElement(By.xpath("//button[@type='submit']"));

		regName.clear();
		regName.sendKeys(administratorName);
		regEmail.clear();
		regEmail.sendKeys(administratorEmail);
		regPass.clear();
		regPass.sendKeys(securePass);
		regPhone.clear();
		regPhone.sendKeys(phoneNumber);
		
//		finishAdminProfile.click();
		finishAdminProfile.sendKeys(Keys.ENTER);

		String path = "//span[text()='" + administratorName + "']";
		WebElement resultName = driver.findElement(By.xpath(path));
//		WebElement resultName = driver.findElement(By.xpath("//*[text()='Zaio Baio']"));

		assertNotNull(resultName);
		assertEquals(resultName.isDisplayed(), true);
		assertEquals(administratorName, resultName.getText());
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
	
	
}
