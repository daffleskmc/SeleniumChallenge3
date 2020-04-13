package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CRMUsers extends CRMBasePage {

    @FindBy(id = "register:firstnameDecorate:firstName")
    WebElement firstName;

    @FindBy(id = "register:lastNameDecorate:lastName")
    WebElement lastName;

    @FindBy(id = "register:emailDecorate:email")
    WebElement email;

    @FindBy(id = "register:usernameDecorate:username")
    WebElement username;

    @FindBy(id = "register:save")
    WebElement save;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    public CRMUsers(WebDriver driver) {
        PageFactory.initElements(driver, this);
       this.driver = driver;
    }

    public List<Map<String, String>> addUser() {
        List<Map<String, String>> data = CRMUtil.getTestDataWithMapReturn("Users", filePath);

        for (int i = 0; i < data.size(); i++) {
            Map<String, String> mapData = data.get(i);
            new CRMAccountSettingsPage().addNewBtn.get(0).click();
            firstName.sendKeys(mapData.get("FIRSTNAME"));
            lastName.sendKeys(mapData.get("LASTNAME"));
            email.sendKeys(mapData.get("EMAILADDRESS"));
            username.sendKeys(mapData.get("USERNAME"));
            save.click();
        }

        return data;
    }
}
