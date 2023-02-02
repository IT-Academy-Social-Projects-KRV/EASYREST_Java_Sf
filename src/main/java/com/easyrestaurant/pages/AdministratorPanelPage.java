package com.easyrestaurant.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministratorPanelPage extends BasePageObject {

    @FindBy(css = "[class*=\"UserMenu-avatar\"]")
    WebElement userMenuAvatar;

    @FindBy(css = "[href=\"/administrator-panel\"]")
    WebElement administratorPanel;

    @FindBy(xpath = "//*[@id=\"root\"]/main/div/header/div/div[2]/div[2]/div/button[4]/span[1]/span/span")
    WebElement ordersTab;

    @FindBy(xpath = ("//span[text()=\"Waiting for confirm\"]"))
    WebElement waitingForConfirm;

    @FindBy(xpath = "//span[text()=\"Accepted\"]")
    WebElement accepted;

    @FindBy(xpath = "//span[text()=\"Assigned waiter\"]")
    WebElement assignedWaiter;

    @FindBy(xpath = "//span[text()=\"Waiters\"]")
    WebElement waiters;

    @FindBy(css = "[href=\"/?tag=pizza\"]")
    WebElement pizzaButton;

    @FindBy(xpath = "//*[@id=\"root\"]/header/div/nav/a[1]")
    WebElement expandDropdownButton;

    @FindBy(xpath = "[class*=\"TagsList\"]")
    WebElement tagsList;


    public AdministratorPanelPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public AdministratorPanelPage navigateToAdministratorPanelPage() {
        click(userMenuAvatar);
        click(administratorPanel);
        return this;
    }

    public AdministratorPanelPage checkSubPagesVisibility() {
        waitForVisibilityOfElement(waiters);
        waitForVisibilityOfElement(assignedWaiter);
        waitForVisibilityOfElement(waitingForConfirm);
        waitForVisibilityOfElement(accepted);
        return this;
    }

    public boolean pageIsDisplayed(WebElement page) {
        return page.isDisplayed();
    }

    public boolean acceptedSubPageIsDisplayed() {
        return pageIsDisplayed(accepted);
    }

    public boolean assignedWaiterSubPageIsDisplayed() {
        return pageIsDisplayed(assignedWaiter);
    }

    public boolean waitingForConfirmSubPageIsDisplayed() {
        return pageIsDisplayed(waitingForConfirm);
    }

    public boolean waitersSubPageIsDisplayed() {
        return pageIsDisplayed(waiters);

    }

    public boolean pizzaPageIsDisplayed() {
        return pageIsDisplayed(pizzaButton);

    }

    public boolean tagsListIsDisplayed() {
        return pageIsDisplayed(tagsList);
    }

    public boolean administratorPanelIsDisplayed() {
        return pageIsDisplayed(ordersTab);
    }
}
