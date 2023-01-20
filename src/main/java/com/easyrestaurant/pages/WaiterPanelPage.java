package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WaiterPanelPage extends BasePageObject {

    private final By inProgressNavBarSelector = By.xpath("//a[@href='/waiter/orders/In progress']");
    private final By historyNavBarSelector = By.xpath("//a[@href='/waiter/orders/History']");
    private final By allExpandArrowsSelector = By.cssSelector("button[aria-label='Show more']");
    private final By closeOrderButtonSelector = By.xpath("//span[contains(text(), 'Close order')]");
    private final By orderInfoTextSelector = By.xpath("//*[@id=\"root\"]/main/div/div[1]/div/div/div[1]/div[2]/span[2]");
    private final By allClientInfoSelector = By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div[1]/div[2]/span[2]");

    public WaiterPanelPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Click on In progress in navigation bar
    public WaiterPanelPage clickOnInProgressNavBar() {
        click(inProgressNavBarSelector);
        return this;
    }

    // Click on Down arrow to expand the first order
    public WaiterPanelPage clickOnDownArrowToExpandOrder() {
        var list = findAll(allExpandArrowsSelector);
        for (WebElement e : list) {
            e.click();
            break;
        }
        return this;
    }

    //Click on Close order
    public WaiterPanelPage clickOnCloseOrder() {
        click(closeOrderButtonSelector);
        return this;
    }

    // Click on History in Navigation bar
    public WaiterPanelPage clickOnHistoryNavBar() {
        click(historyNavBarSelector);
        return this;
    }

    // Get client information
    public String getClientInformation() {
        return getText(orderInfoTextSelector);
    }

    public List<String> getAllClientInfoFromHistory() {
        var list = findAll(allClientInfoSelector);
        List<String> clInfo = new ArrayList<>();
        for (WebElement e : list) {
            var text = e.getText();
            clInfo.add(text);
        }
        return clInfo;
    }
}
