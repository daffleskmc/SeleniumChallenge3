package com.qa.tests;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.pages.*;
import com.sel.qa.util.CRMUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class CRMTestCase1 extends CRMBasePage {

    Logger log = Logger.getLogger(CRMTestCase1.class);

    CRMPeopleAndOrg peopleAndOrg;

    CRMPersonPage personPage;

    CRMLoginPage loginPage;

    CRMHomePage homePage;

    CRMAddPersonNewPage newPersonPage;

    CRMCasePage casePage;

    CRMAddCaseNewPage newCasePage;

    String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    String sheetName = "Person";

    public CRMTestCase1() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initilization();
        loginPage = new CRMLoginPage();
        homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
        peopleAndOrg = homePage.clickPersonIcon();
        newPersonPage = peopleAndOrg.clickAddPersonBtn();
    }

/*    @DataProvider
    public Object[][] getNewPersonData() {
        Object[][] data = CRMUtil.getTestDataWithMapReturn(filePath, sheetName);
        return data;
    }

    @Test(dataProvider = "getNewPersonData")
    public void addNewPersonTest(Map<Object, Object> map) {
        System.out.println(map.get("title"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));
    }*/

/*    @DataProvider
    public Object[][] getNewPersonData() {
        Object[][] data = CRMUtil.getTestData(filePath, sheetName);
        return data;
    }*/

    @DataProvider
    public Object[] persondata()
    {
        List<Map<String, String>> persons=CRMUtil.getTestDataWithMapReturn(sheetName, filePath);
        Object[] data=new Object[persons.size()];
        for(int i=0;i<persons.size();i++ )
        {
            data[i]=persons.get(i);
        }
        return data;
    }

    @Test(priority = 1, dataProvider = "persondata")
    public void addNewPersonTest(Object personData) {

        Map<String, String> data=(Map<String, String>)personData;
        personPage = newPersonPage.addNewPerson(data);
        peopleAndOrg = personPage.clickPersonIcon(); // di pumunta dito?
        Assert.assertTrue(peopleAndOrg.isPeopleAndOrgHeaderDisplayed());

        // Add Person
        Map<String, String> addedPersonData=peopleAndOrg.addedPersonData(data);
        log.debug(">>> Validating new person data <<<");
        Assert.assertEquals(addedPersonData.get("FIRST NAME").contains(data.get("FIRSTNAME")), true);
        Assert.assertEquals(addedPersonData.get("LAST NAME").contains(data.get("LASTNAME")), true);
        /*Assert.assertEquals(addedPersonData.get("JOB TITLE").contains(data.get("TITLE")), true);*/

        // Add Case
        casePage = peopleAndOrg.clickAddCaseBtn(); // click case button on the upper left
        newCasePage = casePage.clickAddCase(); // case page > click add case > new case page
        casePage = newCasePage.addCase(data);

        Map<String, String> addedCaseData = casePage.addedCasePage();
        log.debug(">>> Validating new case data <<<");
        Assert.assertEquals(addedCaseData.get("CASETITLE").contains(data.get("CASENAME")), true);
        Assert.assertEquals(addedCaseData.get("CASESUBTITLE").contains(data.get("CASERELATESTO")), true);
        Assert.assertEquals(addedCaseData.get("CASESTATUS").contains("Open"),true);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
















































   /* CRMLoginPage login;

    CRMHomePage home;

    CRMAddPersonNewPage addPersonNew;

    static String testDataFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    static String sheetName = "Person";

    public CRMAddPersonNewPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        login = new CRMLoginPage();
        home = login.login(props.getProperty("username"), props.getProperty("password"));
        addPersonNew = home.clickPersonIcon();
        addPersonNew.addPersonNew();
    }

    @Test(dataProvider = "getPersonData")
    public void addPersonTest(String title, String firstName, String lastName, String jobTitle, String organisation, String tags, String phonenumber, String phonetype, String emailaddress,
                              String emailtype, String website, String websitetype1, String websitetype2, String physicaladdress, String city, String state, String zip, String country) {

        addPersonNew.addPerson(title, firstName, lastName, jobTitle, organisation, tags, phonenumber, phonetype, emailaddress, emailtype, website, websitetype1, websitetype2, physicaladdress, city,state, zip, country);
    }

    @DataProvider
    public Object[][] getPersonData() {
        Object data[][] = CRMUtil.getTestData(testDataFilePath, sheetName);
        return data;
    }
*/

}
