package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CRMAddCaseNewPage extends CRMBasePage {

    @FindBy(id = "ember62")
    WebElement addCaseNew;

    @FindBy(xpath = "//input[@placeholder='Find a person or organisation']")
    WebElement caseRelatesToFld;

/*    @FindBy(xpath = "//span[@class='search-select__option-text' and text()='%replaceable%']")
    WebElement caseRelatesToDd;*/

    WebElement caseRelatesToDd;

    String caseRelatesToDdStr = "//span[@class='search-select__option-text' and text()='%replaceable%']";

    @FindBy(xpath = "//input[@class='form-input-text']")
    WebElement caseName;

    @FindBy(xpath = "//textarea[@class='form-input-text']")
    WebElement description;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    public CRMAddCaseNewPage() {
        PageFactory.initElements(driver, this);
    }

    public void addCaseNew() {
        CRMUtil.waitForElementToBeClickable(driver, addCaseNew);
        addCaseNew.click();
    }

    public CRMCasePage addCase(Map<String, String> data) {
        caseRelatesToFld.sendKeys(data.get("FIRSTNAME") + " " + data.get("LASTNAME"));

        String person = data.get("FIRSTNAME") + " " + data.get("LASTNAME");

        caseRelatesToDd = driver.findElement(By.xpath("//span[@class='search-select__option-text' and text()='"+ person +"']"));
        caseRelatesToDd.click();

        caseName.sendKeys(data.get("CASENAME"));

        saveBtn.click();
        return new CRMCasePage();
    }
}
