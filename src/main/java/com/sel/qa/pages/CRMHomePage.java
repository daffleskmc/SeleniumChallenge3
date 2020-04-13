package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMHomePage extends CRMBasePage {

    @FindBy(id="ember17")
    WebElement personIcon;

    @FindBy(id="ember23")
    WebElement caseIcon;

    @FindBy(xpath = "//span[@class='nav-bar-username']")
    WebElement accountUsername;

    @FindBy(linkText = "Account Settings")
    WebElement accountSettings;

    public CRMHomePage() {
        PageFactory.initElements(driver, this);
    }

    public CRMPeopleAndOrg clickPersonIcon() {
        CRMUtil.waitForElementToBeClickable(driver, personIcon);
        personIcon.click();

        return new CRMPeopleAndOrg();
    }

    public CRMCasePage clickCaseIcon() {
        CRMUtil.waitForElementToBeVisible(driver, caseIcon);
        caseIcon.click();

        return new CRMCasePage();
    }

    public CRMAccountSettingsPage goToAccountSettingsPage() {
        accountUsername.click();
        accountSettings.click();

        return new CRMAccountSettingsPage();
    }















































/*    @FindBy(id = "ember20")
    WebElement personIcon;


    @FindBy(id = "ember29")
    WebElement caseIcon;

    public CRMHomePage() {
        PageFactory.initElements(driver, this);
    }

    public CRMAddPersonNewPage clickPersonIcon() {
        CRMUtil.waitForElementToBeClickable(driver, personIcon);
        personIcon.click();

        return new CRMAddPersonNewPage();
    }

    public CRMAddCaseNewPage clickCaseIcon() {
        CRMUtil.waitForElementToBeClickable(driver, caseIcon);
        caseIcon.click();

        return new CRMAddCaseNewPage();
    }*/
}
