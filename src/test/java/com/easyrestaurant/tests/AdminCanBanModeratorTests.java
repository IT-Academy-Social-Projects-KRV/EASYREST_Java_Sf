package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminCanBanModeratorTests extends TestUtils {

    @Parameters({"username", "password"})
    @Description("ID-07. Refactor test \"As a site admin, I can ban an moderator\" that implements page object model.")
    @Test()
    public void canBanModerator(String username, String password) {
        web.homePage().navigateToHomePage();
        Allure.step("Home page is opened");
        web.homePage().clickOnSignIn();
        Allure.step("Sign in page is opened");
        web.signInPage().signIn(username, password);
        Allure.step("Typing username and password and clicking on submit button");
        web.adminPanelPage().clickOnModeratorNavBar();
        Allure.step("Clicking on Moderator in navigation bar");

        if(web.adminPanelPage().getActiveStatus().equals("Active")){
            web.adminPanelPage().clickOnChangeStatus();
            Allure.step("Clicking on Change status icon");
        }

        String expectedStatus = "Banned";

        Assert.assertEquals(expectedStatus, web.adminPanelPage().getBannedStatus());
        Allure.step("Verifying that the moderator status is presented");
    }
}
