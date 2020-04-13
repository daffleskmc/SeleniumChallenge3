package com.qa.tests;

import com.sel.qa.base.CRMBasePage;

public class CRMAddNewCasePageTest extends CRMBasePage {


   /* CRMLoginPage loginPage;

    CRMHomePage homePage;

    CRMAddCaseNewPage casePage;

    static String testDataFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\data\\CRMTestData.xlsx";

    static String sheetName = "Case";


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new CRMLoginPage();
        homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
        casePage = homePage.clickCaseIcon();
        casePage.addCaseNew();
    }

    @DataProvider
    public Object[][] getCaseData() {
        Object data[][] = CRMUtil.getTestData(testDataFilePath, sheetName);
        return data;
    }

    @Test(dataProvider = "getCaseData")
    public void addCaseTest(String caseRelatedTo, String caseName, String description) {
        casePage.addCase(caseRelatedTo, caseName, description);
    }

    @AfterMethod
    public void tearDown() {

    }*/
}
