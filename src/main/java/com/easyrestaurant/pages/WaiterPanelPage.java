package com.easyrestaurant.pages;

import com.easyrestaurant.core.Web;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WaiterPanelPage extends BasePageObject {

    @FindBy(xpath = "//a[@href='/waiter/orders/In progress']")
    WebElement inProgressNavBarSelector;
    @FindBy(xpath = "//a[@href='/waiter/orders/History']")
    WebElement historyNavBarSelector;
    @FindBy(css = "button[aria-label='Show more']")
    List<WebElement> allExpandArrowsSelector;
    @FindBy(xpath = "//span[contains(text(), 'Close order')]")
    WebElement closeOrderButtonSelector;
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div[1]/div/div/div[1]/div[2]/span[2]")
    WebElement orderInfoTextSelector;
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/div/div/div/div[1]/div[2]/span[2]")
    List<WebElement> allClientInfoSelector;

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
        for (WebElement e : allExpandArrowsSelector) {
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
        List<String> clInfo = new ArrayList<>();
        for (WebElement e : allClientInfoSelector) {
            var text = e.getText();
            clInfo.add(text);
        }
        return clInfo;
    }
}
