package com.easyrestaurant.tests;

import java.sql.SQLException;
import java.time.Duration;

import com.easyrestaurant.core.TestUtils;
import com.easyrestaurant.utils.CheckRestaurantExist;
import com.easyrestaurant.utils.LoadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateAdministratorProfileTest extends TestUtils {
	
//	WebDriver driver;
	static LoadProperties properties = new LoadProperties();
	static CheckRestaurantExist restaurant = new CheckRestaurantExist();

	@Parameters({"username", "password"})
	@Description("Create Administrator Profile From owner's menu")
	@Test(description = "Create Administrator Profile From owner's menu",
			priority = 6)
	public void createWaiterProfile() throws SQLException {
		//Check if restaurant is exists
		restaurant.findRestaurant();
		//Load username and password from config.properties
		properties.loadProperties();
		web.homePage().navigateToHomePage();

		WebElement login = web.createAdministratorProfilePage().login();
		login.click();
		WebElement fieldEmail = web.createAdministratorProfilePage().fieldEmail();
		fieldEmail.sendKeys(properties.userEmail);
		WebElement fieldPass = web.createAdministratorProfilePage().fieldPass();
		fieldPass.sendKeys(properties.userPassword);
		WebElement logIn = web.createAdministratorProfilePage().logIn();
		logIn.click();
		WebElement profile = web.createAdministratorProfilePage().profile();
		profile.click();
		WebElement profileLink = web.createAdministratorProfilePage().profileLink();
		profileLink.click();
		WebElement myRestaurantsMenu = web.createAdministratorProfilePage().myRestaurantsMenu();
		myRestaurantsMenu.click();
		
		//I need to create restaurant before launch next step!
		WebElement showOptions = web.createAdministratorProfilePage().showOptions();
		showOptions.click();
		WebElement manage = web.createAdministratorProfilePage().manageBtn();
		manage.click();
		WebElement adminMenu = web.createAdministratorProfilePage().adminMenu();
		adminMenu.click();
		WebElement newAdmin = web.createAdministratorProfilePage().newAdmin();
		newAdmin.click();
		
		WebElement regName = web.createAdministratorProfilePage().regName();
		WebElement regEmail = web.createAdministratorProfilePage().regEmail();
		WebElement regPass = web.createAdministratorProfilePage().regPass();
		WebElement regPhone = web.createAdministratorProfilePage().regPhone();
		WebElement finishAdminProfile = web.createAdministratorProfilePage().finishAdminProfile();

		regName.clear();
		regName.sendKeys(web.createAdministratorProfilePage().adminName());
		regEmail.clear();
		regEmail.sendKeys(web.createAdministratorProfilePage().adminEmail());
		regPass.clear();
		regPass.sendKeys(web.createAdministratorProfilePage().adminPass());
		regPhone.clear();
		regPhone.sendKeys(web.createAdministratorProfilePage().adminPhone());
		
//		finishAdminProfile.click();
		finishAdminProfile.sendKeys(Keys.ENTER);
		WebElement resultName = web.createAdministratorProfilePage().myPath();

		assertNotNull(resultName);
		assertTrue(resultName.isDisplayed(), "The administrator's name: not found");
		assertEquals(web.createAdministratorProfilePage().adminName(), resultName.getText());
	}

}
