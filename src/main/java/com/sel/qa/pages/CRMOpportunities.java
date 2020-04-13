package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CRMOpportunities extends CRMBasePage {

    @FindBy(xpath = "//input[@class='ember-text-field ember-view form-input-text milestone-modal__name']")
    WebElement name;

    @FindBy(xpath = "//textarea[@class='ember-text-area ember-view form-input-text milestone-modal__description']")
    WebElement description;

    @FindBy(xpath = "//input[@class='ember-text-field ember-view form-input-text milestone-modal__probability']")
    WebElement probability;

    @FindBy(xpath = "//input[@class='ember-text-field ember-view form-input-text milestone-modal__days-until-stale']")
    WebElement days;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    public CRMOpportunities(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<Map<String, String>> addMilestone() {
        List<Map<String, String>> data = CRMUtil.getTestDataWithMapReturn("Opportunities", filePath);

        for(int i = 0; i < data.size(); i++) {
            Map<String, String> mapData = data.get(i);
            new CRMAccountSettingsPage().addNewBtn.get(0).click();
            name.sendKeys(mapData.get("NAME"));
            description.sendKeys(mapData.get("DESCRIPTION"));
            probability.sendKeys(mapData.get("PROBABILITY"));
            days.sendKeys(mapData.get("DAYS"));
            saveBtn.click();
        }

        return data;
    }
}
