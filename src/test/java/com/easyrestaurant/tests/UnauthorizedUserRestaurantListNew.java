package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

import static java.lang.Thread.sleep;

public class UnauthorizedUserRestaurantListNew extends TestUtils {
	
	@Test(priority = 1)
	public void Tested() {
		web.homePage().navigateToHomePage();
		Allure.step("Home Page is opened");

		web.restaurantsPage().navigateTo("http://localhost:3000/restaurants");
		Allure.step("Restaurants List is opened");

		var url = web.restaurantsPage().getCurrentURL();


		Assert.assertEquals(url, "http://localhost:3000/restaurants", "The URL is equal to expected");
		Allure.step("Verify URL");




	}
}
