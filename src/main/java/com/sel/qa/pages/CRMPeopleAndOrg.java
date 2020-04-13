package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CRMPeopleAndOrg extends CRMBasePage {

    Logger log = Logger.getLogger(CRMPeopleAndOrg.class);

    @FindBy(id="ember62")
    WebElement addPersonBtn;

    String personXpath = "//a[text()='%replaceable%']";

    @FindBy(xpath = "//span[@class='page-header-title']")
    WebElement peopleAndOrgHeader;

    @FindBy(id = "ember23")
    WebElement addCaseBtn;

    public CRMPeopleAndOrg() {
        log.debug(">>> CRMPeopleAndOrg");
        PageFactory.initElements(driver, this);
    }

    public CRMAddPersonNewPage clickAddPersonBtn() {
        addPersonBtn.click();

        return new CRMAddPersonNewPage();
    }

    public CRMCasePage clickAddCaseBtn() {
        addCaseBtn.click();
        return new CRMCasePage();
    }

    public Map<String, String> addedPersonData(Map<String, String> personData)
    {
        Map<String, String> fetchData=new HashMap<String, String>();
        String fullName = personData.get("FIRSTNAME") + " "+ personData.get("LASTNAME");
        log.debug("full name: " + fullName);
        By xpath=CRMUtil.getDynamicXpath(personXpath, fullName);
        CRMUtil.waitTilPresent(driver, xpath);
        String[] rowData=driver.findElement(xpath).getAttribute("innerText").trim().split(" ");
/*		for(int i=0;i<rowData.length;i++)
		{
			System.out.println(">>>>>>>>>>>>> " + i+"="+rowData[i]);
		}*/
        fetchData.put("FIRST NAME", rowData[0]);
        fetchData.put("LAST NAME", rowData[1]);
        fetchData.put("JOB TITLE", rowData[1]);
/*        fetchData.put("ORGANISATION", rowData[3]+" "+rowData[4]);
        fetchData.put("EMAIL ADDRESS", rowData[4]);
        fetchData.put("PHONE NUMBER", rowData[5]);
        fetchData.put("TAGS", rowData[6]);*/
        return fetchData;
    }

    public boolean isPeopleAndOrgHeaderDisplayed() {
        CRMUtil.waitForElementToBeVisible(driver, peopleAndOrgHeader);
        return peopleAndOrgHeader.isDisplayed();
    }

}
