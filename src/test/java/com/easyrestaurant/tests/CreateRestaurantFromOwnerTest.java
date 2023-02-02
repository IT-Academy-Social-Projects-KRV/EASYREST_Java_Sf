package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import com.easyrestaurant.utils.LoadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateRestaurantFromOwnerTest extends TestUtils {

    static LoadProperties properties = new LoadProperties();

    @Parameters({"username", "password"})
    @Description("Create Restaurant from owner's profile")
    @Test(description = "Create Restaurant from owner's profile",
            priority = 6)
    public void createRestaurantFromOwnerTest(){
        properties.loadProperties();
        web.homePage().navigateToHomePage();

        web.createRestaurantFromOwnerPage().login();
        WebElement fieldEmail = web.createRestaurantFromOwnerPage().fieldEmail();
        fieldEmail.sendKeys(properties.userEmail);
        WebElement fieldPass = web.createRestaurantFromOwnerPage().fieldPass();
        fieldPass.sendKeys(properties.userPassword);
        web.createRestaurantFromOwnerPage().logIn();
        web.createRestaurantFromOwnerPage().profile();
        web.createRestaurantFromOwnerPage().profileLink();
        web.createRestaurantFromOwnerPage().myRestaurantsMenu();
        web.createRestaurantFromOwnerPage().addRestaurants();
        web.createRestaurantFromOwnerPage().addName();
        web.createRestaurantFromOwnerPage().addAddress();
        web.createRestaurantFromOwnerPage().submitRestaurantsRecord();

        assertNotNull(web.createRestaurantFromOwnerPage().checkRestaurantName());
        assertTrue(web.createRestaurantFromOwnerPage().checkRestaurantName().isDisplayed(), "The restaurant: Not found");
    }
}
