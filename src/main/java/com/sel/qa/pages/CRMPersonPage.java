package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMPersonPage extends CRMBasePage {

    Logger log = Logger.getLogger(CRMPersonPage.class);
    /*@FindBy(id="ember17")*/
    @FindBy(xpath = "//a[@aria-label='People & Organisations']")
    WebElement personIcon;

    @FindBy(xpath = "//span[@class='party-details__title']")
    WebElement personName;

    public CRMPersonPage() {
        PageFactory.initElements(driver, this);
    }

    public CRMPeopleAndOrg clickPersonIcon() {
        log.debug("start Navigating to People and Organisation page");
        CRMUtil.waitForElementToBeClickable(driver, personIcon);
        /*personIcon.click();*/
        /*personIcon.sendKeys(Keys.ENTER);*/
/*        System.out.println("is person icon displayed? "+ personIcon.isDisplayed());
        System.out.println("is person name displayed?" + personName.isDisplayed());*/
        Actions action = new Actions(driver);
        action.moveToElement(personIcon).click(personIcon);
        action.perform();
        log.debug("end Navigating to People and Organisation page");
        return new CRMPeopleAndOrg();
    }
}
