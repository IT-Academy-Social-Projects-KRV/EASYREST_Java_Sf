package com.easyrestaurant.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateWaiterProfile {
	
	WebDriver driver;
	static LoadProperties properties = new LoadProperties();
	private final static String[] waiterNames = {"Jack Spar","Rumen Radev","Zaio Baio"},
			waiterEmails = {"jack@bg.eu","rumen@bg.eu","zaiobaio@bg.eu"},
			securePass = {"Rambo98432401","854527852Nesega","Neznamtaz1parola6"},
			phoneNumber = {"0894324234","0893432413","0872142767"};

	@Test(description = "Create multiple Waiter Profiles from the owner's menu",
			priority = 2)
	public void createWaiterProfile() throws InterruptedException {
		//Load username and password from config.properties
		properties.loadProperties();
		final String email = properties.userEmail, password = properties.userPassword;
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String url = "http://localhost:3000";
		driver.get(url);
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div/a[1]"));
		login.click();
		WebElement fieldEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[1]/div/div/input"));
		wait.until(ExpectedConditions.elementToBeClickable(fieldEmail));
		fieldEmail.sendKeys(email);
		WebElement fieldPass = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[2]/div/div/input"));
		fieldPass.sendKeys(password);
		WebElement logIn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[2]/form/div/div[3]/div/button"));
		wait.until(ExpectedConditions.elementToBeClickable(logIn));
		logIn.click();
		WebElement profile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//div[@id='root']/header/div//button[@type='button']//div[.='J']")));
		profile = driver.findElement(By.xpath("//html//div[@id='root']/header/div//button[@type='button']//div[.='J']"));
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
		WebElement waiterMenu = driver.findElement(By.xpath("/html//div[@id='root']//ul/a[2]//span[.='Waiters']"));
		waiterMenu.click();	
		WebElement addWaiter = driver.findElement(By.xpath("//button[@title='Add Waiter']"));
		addWaiter.click();
		
		WebElement regName = driver.findElement(By.name("name"));		
		WebElement regEmail = driver.findElement(By.name("email"));
		WebElement regPass = driver.findElement(By.name("password"));
		WebElement regPhone = driver.findElement(By.name("phone_number"));
		WebElement finishWaiterProfile = driver.findElement(By.xpath("//button[@type='submit']"));
		WebElement alertDialog, alertDialogClose;

		for(int i = 0; i < waiterNames.length;i++) {
			wait.until(ExpectedConditions.elementToBeClickable(regName));
			regName.sendKeys(waiterNames[i]);
			regEmail.sendKeys(waiterEmails[i]);
			regPass.sendKeys(securePass[i]);
			regPhone.sendKeys(phoneNumber[i]);
			
			wait.until(ExpectedConditions.elementToBeClickable(finishWaiterProfile));
			finishWaiterProfile.click();
			alertDialog = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alertdialog']")));
			//After 2nd record the alert dialog stuck. In order to finish the test I decided to close it manually.
			alertDialogClose = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Close']")));
			alertDialogClose.click();
			wait.until(ExpectedConditions.invisibilityOf(alertDialog));
		}
		
		WebElement resultName;
		String findWaiterName = "";
		for (int j = 0; j < waiterNames.length; j++) {
			findWaiterName = "//span[text()='" + waiterNames[j] + "']";
			resultName = driver.findElement(By.xpath(findWaiterName));
			
			assertNotNull(resultName);
			assertEquals(resultName.isDisplayed(), true);
			assertEquals(waiterNames[j], resultName.getText());
		}
		
	}
	
	@AfterTest
	public void endOfTest() {
		driver.close();
	}
		
}
