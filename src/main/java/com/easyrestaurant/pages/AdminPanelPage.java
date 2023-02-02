package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelPage extends BasePageObject {

    @FindBy(xpath = "//span[contains(text(),\"Users\")]")
    WebElement userNavBarSelector;
    @FindBy(xpath = "//span[contains(text(),\"Owners\")]")
    WebElement ownerNavBarSelector;
    @FindBy(xpath = "//span[contains(text(),\"Moderators\")]")
    WebElement moderatorNavBarSelector;
    @FindBy(xpath = "/html/body/div/div/main/div[2]/table/tbody/tr[1]/td[5]/button")
    WebElement statusButtonSelector;
    @FindBy(xpath = "//p[contains(text(),\"Active\")]")
    WebElement statusActiveSelector;
    @FindBy(xpath = "//p[contains(text(),\"Banned\")]")
    WebElement statusBannedSelector;
    @FindBy(xpath = "//span[contains(text(),\"Add moderator\")]")
    WebElement addModeratorButtonSelector;
    @FindBy(name = "name")
    WebElement moderatorNameSelector;
    @FindBy(name = "email")
    WebElement moderatorEmailSelector;
    @FindBy(name = "phoneNumber")
    WebElement moderatorPhoneNumberSelector;
    @FindBy(css = "input[name='birthDate']")
    WebElement moderatorBDSelector;
    @FindBy(xpath = "/html//div[@role='dialog']/div[@role='document']//h6")
    WebElement bdYearButtonSelector;
    @FindBy(xpath = "//div[contains(text(),\"1990\")]")
    WebElement bdYearSelector;
    @FindBy(xpath = "//span[contains(text(),\"21\")]")
    WebElement bdDataButtonSelector;
    @FindBy(css = "button:nth-of-type(2) > .MuiButton-label-81")
    WebElement oKButtonSelector;
    @FindBy(name = "password")
    WebElement moderatorPasswordSelector;
    @FindBy(name = "repeated_password")
    WebElement moderatorRepeatedPasswordSelector;
    @FindBy(xpath = "//span[contains(text(),\"Create account\")]")
    WebElement createdModeratorButtonSelector;
    @FindBy(css = "[scope='row']")
    WebElement createdModeratorNameSelector;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[1]")
    WebElement createdModeratorEmailSelector;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[2]")
    WebElement createdModeratorPhoneSelector;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr/td[3]")
    WebElement createdModeratorDBSelector;
    @FindBy(xpath = "//p[contains(text(),\"Email is not valid\")]")
    WebElement invalidEmailErrorMessageSelector;

     public AdminPanelPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Click on Moderator section in navigation bar
    public AdminPanelPage clickOnModeratorNavBar() {
        click(moderatorNavBarSelector);
        return this;
    }
    // Click on Owner section in navigation bar
    public AdminPanelPage clickOnOwnerNavBar() {
        click(ownerNavBarSelector);
        return this;
    }
    // Click on User section in navigation bar
    public AdminPanelPage clickOnUserNavBar() {
        click(userNavBarSelector);
        return this;
    }
    // Click on button for changing status
    public AdminPanelPage clickOnChangeStatus() {
        click(statusButtonSelector);
        return this;
    }
    //Create moderator with valid date
    public AdminPanelPage creatModeratorWithValidDate(String moderatorName, String moderatorEmail, String moderatorPhoneNumber,
                                                      String moderatorPassword, String moderatorRepeatedPassword){
        click(addModeratorButtonSelector);
        type(moderatorNameSelector,moderatorName );
        type(moderatorEmailSelector, moderatorEmail);
        type(moderatorPhoneNumberSelector, moderatorPhoneNumber);
        moderatorBDSelector.click();
        bdYearButtonSelector.click();
        bdYearSelector.click();
        bdDataButtonSelector.click();
        oKButtonSelector.click();
        type(moderatorPasswordSelector, moderatorPassword);
        type(moderatorRepeatedPasswordSelector, moderatorRepeatedPassword);
        createdModeratorButtonSelector.click();
        return this;
    }
    // Get moderator name
    public String getModeratorName() { return getText(createdModeratorNameSelector); }
    // Get moderator email
    public String getModeratorEmail() { return getText(createdModeratorEmailSelector); }
    // Get moderator phone number
    public String getModeratorPhoneNumber() { return getText(createdModeratorPhoneSelector); }
    // Get moderator date of birth
    public String getModeratorBD() { return getText(createdModeratorDBSelector); }
    // Get moderator status
    public String getActiveStatus() { return getText(statusActiveSelector); }
    public String getBannedStatus() { return getText(statusBannedSelector); }

    //Create moderator with invalid email
    public String creatModeratorWithInvalidEmail(String moderatorName, String moderatorInvalidEmail){
         click(addModeratorButtonSelector);
        type(moderatorNameSelector,moderatorName );
        type(moderatorEmailSelector, moderatorInvalidEmail);
        return getText(invalidEmailErrorMessageSelector);
    }
    public AdminPanelPage deleteModeratorFromDataBase(){
        psql.connectToDb();
         String query = "DELETE FROM USERS WHERE NAME='Ivan Ivanov';";
         psql.executeUpdate(query);
         return this;
    }
}
