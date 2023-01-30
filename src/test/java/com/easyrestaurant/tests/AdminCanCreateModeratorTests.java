package com.easyrestaurant.tests;

import com.easyrestaurant.core.TestUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminCanCreateModeratorTests extends TestUtils {

    @Parameters({"username", "password", "moderatorName", "moderatorEmail",
                "moderatorPhoneNumber", "moderatorPassword", "moderatorRepeatedPassword"})
    @Description("ID-09. Refactor test \"As a site admin, I can create moderator\" that implements page object model.")
    @Test()
    public void canCreateModerator_withValidData(String username, String password, String moderatorName, String moderatorEmail, String moderatorPhoneNumber,
                                                 String moderatorPassword, String moderatorRepeatedPassword) {
        web.homePage().navigateToHomePage();
        Allure.step("Home page is opened");
        web.homePage().clickOnSignIn();
        Allure.step("Sign in page is opened");
        web.signInPage().signIn(username, password);
        Allure.step("Typing username and password and clicking on submit button");
        web.adminPanelPage().clickOnModeratorNavBar();
        Allure.step("Clicking on Moderator in navigation bar");
        web.adminPanelPage().creatModeratorWithValidDate(moderatorName, moderatorEmail, moderatorPhoneNumber,
                moderatorPassword, moderatorRepeatedPassword);
        Allure.step("Typing moderator with valid name, email, phone number, date of birth, password and repeated password ");

        String actualName = "Ivan Ivanov";
        String actualEmail = "ivan@test.com";
        String actualPhone = "+359123456789";
        String actualDB = "21.01.1990";
        String actualStatus = "Active";

        Assert.assertEquals(actualName, web.adminPanelPage().getModeratorName(), "The name is not displayed" );
        Assert.assertEquals(actualEmail, web.adminPanelPage().getModeratorEmail(), "The email is not displayed");
        Assert.assertEquals(actualPhone, web.adminPanelPage().getModeratorPhoneNumber(), "The phone numer is not displayed");
        Assert.assertEquals(actualDB, web.adminPanelPage().getModeratorBD(), "The date of birth is not displayed");
        Assert.assertEquals(actualStatus, web.adminPanelPage().getActiveStatus(), "The sastus is not displayed");
        Allure.step("Verifying that moderator's name is presented");
        Allure.step("Verifying that moderator's email is presented");
        Allure.step("Verifying that moderator's phone number is presented");
        Allure.step("Verifying that moderator's date of birth is presented");
        Allure.step("Verifying that moderator's status is presented");
        //Delete created moderator from database
        web.adminPanelPage().deleteModeratorFromDataBase();
    }
    @Parameters({"username", "password", "moderatorName", "moderatorInvalidEmail"})
    @Description("ID-09. Refactor test \"As a site admin, I can create moderator\" that implements page object model.")
    @Test()
    public void canCreateModerator_withInvalidEmail(String username, String password, String moderatorName, String moderatorInvalidEmail) {
        web.homePage().navigateToHomePage();
        Allure.step("Home page is opened");
        web.homePage().clickOnSignIn();
        Allure.step("Sign in page is opened");
        web.signInPage().signIn(username, password);
        Allure.step("Typing username and password and clicking on submit button");
        web.adminPanelPage().clickOnModeratorNavBar();
        Allure.step("Clicking on Moderator in navigation bar");
        String actualReasult = web.adminPanelPage().creatModeratorWithInvalidEmail(moderatorName, moderatorInvalidEmail);
        Allure.step("Typing moderator name and moderator invalid email");

        String expectedMsg = "Email is not valid";

        Assert.assertEquals(expectedMsg, actualReasult);
        Allure.step("Verifying that the error message for invalid email is presented");
    }

}
