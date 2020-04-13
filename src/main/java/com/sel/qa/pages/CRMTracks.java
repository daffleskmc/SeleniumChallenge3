package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class CRMTracks extends CRMBasePage {

    @FindBy(id = "j_id108:trackDescriptionDecorate:trackDescription")
    WebElement name;

    @FindBy(id = "j_id108:taskLines:0:taskDescriptionDecorate:taskDescription")
    WebElement taskDescription;

    @FindBy(id = "j_id108:taskLines:0:taskDaysAfterDecorate:taskDaysAfter")
    WebElement due;

    @FindBy(xpath = "//span[@class='ui-selectmenu-text ui-selectmenu-text-none']")
    WebElement category;

    @FindBy(xpath = "//select[@name='j_id108:taskLines:0:taskAssignmentDecorate:j_id202']")
    WebElement assignee;

    @FindBy(xpath = "//a[@class='btn-primary btn-clear singlesubmit']")
    WebElement saveBtn;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    By dropdown = By.xpath("//span[@class='ui-selectmenu-text ui-selectmenu-text-none']");

    public CRMTracks(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<Map<String, String>> addTracks() {

        List<Map<String, String>> data = CRMUtil.getTestDataWithMapReturn("Tracks", filePath);

        for(int i = 0; i < data.size(); i++) {
            Map<String, String> mapData = data.get(i);
            new CRMAccountSettingsPage().addNewBtn.get(0).click();
            name.sendKeys(mapData.get("NAME"));
            taskDescription.sendKeys(mapData.get("TASKDESCRIPTION"));
            due.sendKeys(mapData.get("DUE"));

//            Actions action = new Actions(driver);
//            action.click(category).build().perform();
//            action.click(driver.findElement(By.xpath("//li[contains(text(), '"+ mapData.get("CATEGORY") +"')]"))).build().perform();

            CRMUtil.selectFromDropdown(driver, dropdown, mapData.get("CATEGORY"));

            Select select = new Select(assignee);
            select.selectByVisibleText(mapData.get("ASSIGNEE"));

            saveBtn.click();
        }

        return data;
    }


}
