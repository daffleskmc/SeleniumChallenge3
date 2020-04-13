package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class CRMAddPersonNewPage extends CRMBasePage {

    // TO DO

    List<WebElement> commonDropdown = driver.findElements(By.xpath("//div[@class='single-select__selected-option']"));

    @FindBy(xpath = "//div[@class='single-select chunky party-form-title']")
    WebElement title;

    By dropdown = By.xpath("//div[@class='single-select__option']");

    @FindBy(xpath = "//input[@class='form-input-text party-form-first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@class='form-input-text party-form-last-name']")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//input[@class='form-input-text party-form-job-title']")
    WebElement jobTitle;

    @FindBy(xpath = "//input[@class='search-select__input']")
    WebElement organisation;

    @FindBy(xpath = "//div[@class='search-select__option search-select__option--active search-select__option--selected']")
    WebElement addOrganisation;

    @FindBy(xpath = "//input[@class='item-select__input']")
    WebElement tags;

    @FindBy(id = "select-box-el-473")
    WebElement addTags;

    @FindBy(xpath = "//input[@class='form-input-text party-form-phone-number']")
    WebElement phone;

    @FindBy(xpath = "//div[@id='select-box-el-138']")
    WebElement phoneType;

/*    @FindBy(xpath = "//div[@class='single-select chunky']")
    WebElement dropDown;*/

    @FindBy(xpath = "//button[@class='button button--primary']")
    WebElement linkOrganisationBtn;

    public CRMAddPersonNewPage() {
        PageFactory.initElements(driver, this);
    }

    public CRMPersonPage addNewPerson(Map<String, String> personData) {
        // title dropdown
        commonDropdown.get(0).click();
        CRMUtil.selectFromDropdown(driver, dropdown, personData.get("TITLE"));

        firstName.sendKeys(personData.get("FIRSTNAME"));
        lastName.sendKeys(personData.get("LASTNAME"));
        jobTitle.sendKeys(personData.get("JOBTITLE"));
        organisation.sendKeys(personData.get("ORGANISATION"));
        tags.sendKeys(personData.get("TAGS"));
        phone.sendKeys(personData.get("PHONENUMBER"));

        // phone type dropdown
        commonDropdown.get(1).click();
        CRMUtil.selectFromDropdown(driver, dropdown, personData.get("PHONETYPE"));

        CRMUtil.scrollToBottomOfPage(driver);

        submitBtn.click();

        // for the pop up window for link organisation

        CRMUtil.checkIfPopupIsPresent(driver, linkOrganisationBtn);

        return new CRMPersonPage();
    }










































  /*  @FindBy(xpath = "//a[contains(text(), 'Add Person')]")
    WebElement addPerson;

    @FindBy(id = "select-box-el-89")
    WebElement title;

    @FindBy(xpath = "//input[@class='form-input-text party-form-first-name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@class='form-input-text party-form-last-name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@class='form-input-text party-form-job-title']")
    WebElement jobTitle;

//    @FindBy(id = "select-box-el-144")
    @FindBy(xpath = "//input[@class='search-select__input']")
    WebElement org;

    @FindBy(id = "select-box-el-183")
    WebElement orgValue;

    @FindBy(id = "select-box-el-151")
    WebElement tags;

    @FindBy(xpath = "//input[@class='form-input-text party-form-phone-number']")
    WebElement phone;

    By dropdown = By.xpath("//div[@class='single-select__option']");

    @FindBy(id = "select-box-el-140")
    WebElement phoneType;

    @FindBy(xpath = "//input[@class='form-input-text party-form-email-address']")
    WebElement email;

    @FindBy(id = "select-box-el-152")
    WebElement emailType;

    @FindBy(xpath = "//input[@class='form-input-text party-form-website']")
    WebElement website;

    @FindBy(id = "select-box-el-164")
    WebElement websiteType1;

    @FindBy(id = "select-box-el-169")
    WebElement websiteType2;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    public CRMAddPersonNewPage() {
        PageFactory.initElements(driver, this);
    }

    public void addPersonNew() {
        CRMUtil.waitForElementToBeClickable(driver, addPerson);
        addPerson.click();

//        return new CRMAddPersonNewPage();
    }

    public CRMPersonPage addPerson(String strTitle, String strFirstName, String strLastName, String strJobTitle, String strOrganisation, String strTags, String strPhonenumber, String strPhonetype, String strEmailaddress,
                                   String strEmailtype, String strWebsite, String strWebsitetype1, String strWebsitetype2, String strPhysicaladdress, String strCity, String strState, String strZip, String strCountry) {
        CRMUtil.waitForElementToBeVisible(driver, title);
        title.click();

        // 1. title
        CRMUtil.selectFromDropDown(driver, dropdown, strTitle);

        // 2.
        firstName.sendKeys(strFirstName);
        lastName.sendKeys(strLastName);
        jobTitle.sendKeys(strJobTitle);
        org.sendKeys(strOrganisation);
        orgValue.click();
        tags.sendKeys(strTags);

        phone.sendKeys(strPhonenumber);
        phoneType.click();
        driver.findElement(By.xpath("//div[@id='select-box-el-139']//div[@class='single-select__options is-bottom-left']//div[text()='" + strPhonetype + "']")).click();

        CRMUtil.scrollToBottomOfPage(driver);

        email.sendKeys(strEmailaddress);
        emailType.click();
        driver.findElement(By.xpath("//div[@id='select-box-el-151']//div[@class='single-select__options is-bottom-left']//div[text()='" + strEmailtype + "']")).click();

        website.sendKeys(strWebsite);
        websiteType1.click();
        driver.findElement(By.xpath("//div[@id='select-box-el-163']//div[@class='single-select__options is-bottom-left']//div[text()='" + strWebsitetype1 + "']")).click();
        websiteType2.click();
        driver.findElement(By.xpath("//div[@id='select-box-el-168']//div[@class='single-select__options is-bottom-left']//div[text()='" + strWebsitetype2 + "']")).click();

        saveBtn.click();

        return new CRMPersonPage();
    }*/
}
