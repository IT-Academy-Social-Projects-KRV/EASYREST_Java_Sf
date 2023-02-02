package com.easyrestaurant.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AsAdmin_ICan_CreateModerator {

	@Test
	public void test_UI_createModerator_withValidData() {

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

		WebElement moderatorSectionElement = driver.findElement(By.xpath("/html/body/div/div/ul/a[3]/div[2]/span"));
		moderatorSectionElement.click();

		WebElement addModeratorButton = driver.findElement(By.xpath("/html/body/div/div/main/a/span[1]"));
		addModeratorButton.click();

		//Add moderator name
		WebElement moderatorNameElement = driver.findElement(By.name("name"));
		moderatorNameElement.sendKeys("Ivan Ivanov");

		//Add moderator e-mail
		WebElement moderatorEmailElement = driver.findElement(By.name("email"));
		moderatorEmailElement.sendKeys("ivan@test.com");

		//Add moderator phone
		WebElement moderatorPhoneElement = driver.findElement(By.name("phoneNumber"));
		moderatorPhoneElement.sendKeys("+359123456789");

		//Add moderator Date of Birth
		WebElement moderatorBDElement = driver.findElement(By.xpath("/html/body/div/div/main/div/div/form/div/div/div[4]/div/div[1]/div/div"));
		moderatorBDElement.click();

		// Add moderator year of birth
		WebElement bdYearButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[1]/h6"));
		bdYearButton.click();
		WebElement bdYearElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[91]"));
		bdYearElement.click();

		// Add moderator data of birth
		WebElement bdDataButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[3]/div/div[4]/div[1]/button"));
		bdDataButton.click();
		WebElement okButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button[2]/span[1]"));
		okButton.click();

		//Add password
		WebElement moderatorPasswordElement = driver.findElement(By.name("password"));
		moderatorPasswordElement.sendKeys("12345678");

		//Confirm password
		WebElement moderatorConfirmPasswordElement = driver.findElement(By.name("repeated_password"));
		moderatorConfirmPasswordElement.sendKeys("12345678");

		//Create moderator
		WebElement createModeratorButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/form/div/div/div[7]/div/button"));
		createModeratorButton.click();

		//Asser that created moderator exist on the UI
		WebElement createdModeratorName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/th"));
		WebElement createdModeratorEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[1]"));
		WebElement createdModeratorPhone = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[2]"));
		WebElement createdModeratorDB = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[3]"));
		WebElement createdModeratorStatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[4]/p"));

		String expectedName = "Ivan Ivanov";
		String expectedEmail = "ivan@test.com";
		String expectedPhone = "+359123456789";
		String expectedDB = "21.01.1990";
		String expectedStatus = "Active";

		Assert.assertEquals(expectedName, createdModeratorName.getText());
		Assert.assertEquals(expectedEmail, createdModeratorEmail.getText());
		Assert.assertEquals(expectedPhone, createdModeratorPhone.getText());
		Assert.assertEquals(expectedDB, createdModeratorDB.getText());
		Assert.assertEquals(expectedStatus, createdModeratorStatus.getText());

		driver.close();
	}
	@Test
	public void test_UI_createModerator_with_InvalidEmail() {

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

		WebElement moderatorSectionElement = driver.findElement(By.xpath("/html/body/div/div/ul/a[3]/div[2]/span"));
		moderatorSectionElement.click();

		WebElement addModeratorButton = driver.findElement(By.xpath("/html/body/div/div/main/a/span[1]"));
		addModeratorButton.click();

		//Add moderator name
		WebElement moderatorNameElement = driver.findElement(By.name("name"));
		moderatorNameElement.sendKeys("Ivan Ivanov");

		//Add moderator e-mail
		WebElement moderatorEmailElement = driver.findElement(By.name("email"));
		moderatorEmailElement.sendKeys("ivan@test");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		//Asser that e-mail is invalid
		WebElement errorEmailMsg = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/form/div/div/div[2]/div/p"));
		String expectedMsg = "Email is not valid";

		Assert.assertEquals(expectedMsg, errorEmailMsg.getText());

		driver.close();
	}
}
