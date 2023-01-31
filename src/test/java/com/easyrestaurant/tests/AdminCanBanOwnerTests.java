package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminCanBanOwnerTests extends TestUtils {

    @Parameters({"username", "password"})
    @Description("ID-05. Refactor test \"As a site admin, I can ban an owner\" that implements page object model.")
    @Test()
    public void canBanOwner(String username, String password) {
        web.homePage().navigateToHomePage();
        Allure.step("Home page is opened");
        web.homePage().clickOnSignIn();
        Allure.step("Sign in page is opened");
        web.signInPage().signIn(username, password);
        Allure.step("Typing username and password and clicking on submit button");
        web.adminPanelPage().clickOnOwnerNavBar();
        Allure.step("Clicking on Owner in navigation bar");

        if(web.adminPanelPage().getActiveStatus().equals("Active")){
            web.adminPanelPage().clickOnChangeStatus();
            Allure.step("Clicking on Change status icon");
        }

        String expectedStatus = "Banned";

        Assert.assertEquals(expectedStatus, web.adminPanelPage().getBannedStatus());
        Allure.step("Verifying that the owner status is presented");
    }
}
