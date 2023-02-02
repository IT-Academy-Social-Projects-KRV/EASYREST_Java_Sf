package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdministratorPanelTests extends TestUtils {

    @Parameters({"username", "password"})
    @Description("ID-18, after log in, administrator can see subpages on administrator panel.")
    @Test(priority = 1)
    public void administratorCanSeeSubpages(String username, String password) {
        web.homePage().navigateToHomePage();
        Allure.step("Home page is opened");
        web.homePage().clickOnSignIn();
        Allure.step("Sign in page is opened");
        web.signInPage().signIn(username, password);
        Allure.step("Typing username and password and clicking on submit button");
        web.administratorPanelPage().navigateToAdministratorPanelPage();
        Allure.step("Navigating to Administrator panel page");


        Assert.assertTrue(web.administratorPanelPage().assignedWaiterSubPageIsDisplayed());
        Assert.assertTrue(web.administratorPanelPage().acceptedSubPageIsDisplayed());
        Assert.assertTrue(web.administratorPanelPage().waitersSubPageIsDisplayed());
        Assert.assertTrue(web.administratorPanelPage().waitingForConfirmSubPageIsDisplayed());
        Allure.step("Verify that subpages are displayed for administrator in administrator panel");
    }

    @Description("ID-15, after log in, administrator can see Restaurants List.")
    @Test(priority = 2)
    public void administratorCanSeeRestaurantsLists(String username, String password) {

        web.homePage().clickOnRestaurantList();
        Allure.step("Navigating to Restaurants list from Administrator panel");


        Assert.assertTrue(web.administratorPanelPage().pizzaPageIsDisplayed());
        Allure.step("Verify that pizza is displayed for administrator in restaurants list");
    }

    @Description("ID-16, after log in, administrator can see Home Page.")
    @Test(priority = 3)
    public void administratorCanSeeHomePage(String username, String password) {

        web.homePage().navigateToHomePage();
        Allure.step("Open home page.");


        Assert.assertTrue(web.administratorPanelPage().tagsListIsDisplayed());
        Allure.step("Verify that tags lists on Home Page is displayed for administrator");
    }

    @Description("ID-17, after log in, administrator can see Home Page.")
    @Test(priority = 4)
    public void administratorCanSeeAdministratorPanel(String username, String password) {

        web.administratorPanelPage().navigateToAdministratorPanelPage();
        Allure.step("Navigating to Administrator Panel page.");


        Assert.assertTrue(web.administratorPanelPage().administratorPanelIsDisplayed());
        Allure.step("Verify that orders list in Administrator Panel is displayed");
    }
}