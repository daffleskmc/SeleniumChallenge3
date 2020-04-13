package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;


public class CRMTags extends CRMBasePage {

    @FindBy(id="j_id162:tagNameDecorate:tagName")
    WebElement tagName;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    WebElement saveBtn;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    public CRMTags(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<Map<String, String>> addTag() {
        List<Map<String, String>> data = CRMUtil.getTestDataWithMapReturn("Tag", filePath);

        for(int i = 0; i < data.size(); i++) {
            Map<String, String > mapData = data.get(i);
            new CRMAccountSettingsPage().addNewBtn.get(0).click();
            mapData.get("NAME");
            saveBtn.click();
        }

        return data;
    }



}
