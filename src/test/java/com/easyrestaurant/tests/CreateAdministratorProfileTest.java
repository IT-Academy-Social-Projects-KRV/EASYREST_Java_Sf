package com.easyrestaurant.tests;

import java.sql.SQLException;


import com.easyrestaurant.core.TestUtils;
import com.easyrestaurant.utils.LoadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateAdministratorProfileTest extends TestUtils {
	
//	WebDriver driver;
	static LoadProperties properties = new LoadProperties();
//	static CheckRestaurantExist restaurant = new CheckRestaurantExist();

	@Parameters({"username", "password"})
	@Description("Create Administrator Profile From owner's menu")
	@Test(description = "Create Administrator Profile From owner's menu",
			priority = 7)
	public void createAdministratorProfile() throws SQLException {
		//Check if restaurant is exists in the DB
//		restaurant.findRestaurant();
		//Load username and password from config.properties
		properties.loadProperties();
		web.homePage().navigateToHomePage();

		web.createAdministratorProfilePage().login();
		WebElement fieldEmail = web.createAdministratorProfilePage().fieldEmail();
		fieldEmail.sendKeys(properties.userEmail);
		WebElement fieldPass = web.createAdministratorProfilePage().fieldPass();
		fieldPass.sendKeys(properties.userPassword);
		web.createAdministratorProfilePage().logIn();
		web.createAdministratorProfilePage().profile();
		web.createAdministratorProfilePage().profileLink();
		web.createAdministratorProfilePage().myRestaurantsMenu();
		
		//I need to create restaurant before launch next step!
		//Run at least one time 'createRestaurantFromOwnerTest' or 'createRestaurantFromOwnerSuite' in order to fix the issue
		web.createAdministratorProfilePage().showOptions();
		web.createAdministratorProfilePage().manageBtn();
		web.createAdministratorProfilePage().adminMenu();
		web.createAdministratorProfilePage().newAdmin();
		
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

		finishAdminProfile.sendKeys(Keys.ENTER);
		WebElement resultName = web.createAdministratorProfilePage().myPath();

		assertNotNull(resultName);
		assertTrue(resultName.isDisplayed(), "The administrator's name: not found");
		assertEquals(web.createAdministratorProfilePage().adminName(), resultName.getText());
	}

}
