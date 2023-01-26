package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModeratorPanelPage extends BasePageObject {

    private final By topNavBarButtonSelector = By.xpath("//button[@role='tab']");
    private final By restaurantsNameSelector = By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div/div/div[1]/div/span[1]");
    private final By approveButtonSelector = By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div/div/div[3]/button[2]");
    private final By disapproveButtonSelector = By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div/div/div[3]/button[1]");
    private final By approvedRestaurantsNameSelector = By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div/div/div[1]/div[2]/span[1]");
    private final By restaurantStatusSelector = By.xpath("//*[@id=\"root\"]/div/main/div[2]/div/div/div/div[2]/div[2]/span");
    private final By snackBar = By.id("client-snackbar");


    public ModeratorPanelPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public ModeratorPanelPage clickOnNavBarButton(String buttonToClick) {
        waitForPresenceOfElement(topNavBarButtonSelector);
        List<WebElement> bttnList = findAll(topNavBarButtonSelector);
        for (WebElement e : bttnList) {
            if (e.getText().toLowerCase().contains(buttonToClick.toLowerCase())) {
                e.click();
                break;
            }
        }
        return this;
    }

    public ModeratorPanelPage approveRestaurant(String restName) {
        waitForPresenceOfElement(restaurantsNameSelector);
        List<WebElement> restNames = findAll(restaurantsNameSelector);
        for (WebElement e : restNames) {
            if (e.getText().equalsIgnoreCase(restName.toLowerCase())) {
                click(approveButtonSelector);
                break;
            }
        }
        return this;
    }

    public String getSnackBarText() {
        return getText(snackBar).toLowerCase();
    }

    public ModeratorPanelPage disapproveRestaurant(String restName) {
        waitForPresenceOfElement(disapproveButtonSelector);
        var restNames = findAll(restaurantsNameSelector);
        for (WebElement e : restNames) {
            if (e.getText().toLowerCase().contains(restName.toLowerCase())) {
                click(disapproveButtonSelector);
                break;
            }
        }
        return this;
    }

    public boolean isRestaurantApproved(String restName, String status) {
        waitForPresenceOfElement(approvedRestaurantsNameSelector);
        List<WebElement> restNames = findAll(approvedRestaurantsNameSelector);
        for (WebElement e : restNames) {
            if (e.getText().equalsIgnoreCase(restName.toLowerCase())) {
                waitForPresenceOfElement(restaurantStatusSelector);
                if (find(restaurantStatusSelector).getText().equalsIgnoreCase(status)) {
                    return true;
                }
            }
        }
        return false;
    }
}
