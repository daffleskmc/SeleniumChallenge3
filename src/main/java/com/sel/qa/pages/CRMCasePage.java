package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CRMCasePage extends CRMBasePage {

    @FindBy(xpath = "//a[text()='Add Case']")
    WebElement addCase;

    @FindBy(xpath = "//div[@class='entity-details__title']")
    WebElement caseTitle;

    @FindBy(xpath = "//span[@class='kase-summary__status-blob kase-summary__status-blob--open']")
    WebElement caseStatus;

    @FindBy(xpath = "//a[@class='ember-view']")
    WebElement caseSubtitle;

    String caseNameXpath = "//div[text()='%replaceable%']";

    String caseRelatesToXpath = "//a[text()='%replaceable%']";

    public CRMCasePage() {
        PageFactory.initElements(driver, this);
    }

    public CRMAddCaseNewPage clickAddCase() {

        addCase.click();

        return new CRMAddCaseNewPage();
    }

    public Map<String, String> addedCasePage() {

        Map<String, String> fetchData = new HashMap<String, String>();
        CRMUtil.waitForElementToBeVisible(driver, caseTitle);
        fetchData.put("CASETITLE", caseTitle.getText());
        fetchData.put("CASESUBTITLE", caseSubtitle.getText());
        fetchData.put("CASESTATUS", caseStatus.getText());

        return fetchData;
    }
}
