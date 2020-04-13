package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CRMTaskCategories extends CRMBasePage {

    @FindBy(xpath = "//input[@class='ember-text-field ember-view form-input-text']")
    WebElement name;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement saveBtn;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    public CRMTaskCategories(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<Map<String, String>> addTask() {

        List<Map<String,String>> data = CRMUtil.getTestDataWithMapReturn("Task", filePath);

        for(int i = 0; i < data.size(); i++) {
            Map<String, String> mapData = data.get(i);
            new CRMAccountSettingsPage().addNewBtn.get(0).click();
            name.sendKeys(mapData.get("NAME"));
            saveBtn.click();
        }

        return data;
    }


}
