package com.easyrestaurant.tests;

//import java.time.Duration;
import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.bouncycastle.asn1.crmf.SinglePubInfo.web;

public class UnauthorizedUserDetailsRestaurantNew  extends  TestUtils{
	
	@Test (priority = 2)
	public void Tested2() {
		web.homePage().navigateToHomePage();
		Allure.step("Home Page is opened");

		/*web.restaurantsPage().navigateTo("http://localhost:3000/restaurants");
		*/Allure.step("Restaurants List is opened");

		web.restaurantsPage().navigateTo("http://localhost:3000/restaurants/2");
		Allure.step("Restaurant Bennet-Prince details is opened");

		var urlDetails = web.restaurantsPage().getCurrentURL();

		Assert.assertEquals(urlDetails, "http://localhost:3000/restaurants/2", "The URL is equal to expected");
		Allure.step("Verify URL Restaurant Name Details");


	}



}