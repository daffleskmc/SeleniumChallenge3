package com.qa.tests;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.pages.CRMHomePage;
import com.sel.qa.pages.CRMLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMLoginPageTest extends CRMBasePage {

    CRMLoginPage loginPage;

    CRMHomePage homePage;

    public CRMLoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initilization();
        loginPage = new CRMLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.login(props.getProperty("username"), props.getProperty("password"));

    }

    @AfterMethod
    public void tearDown() {

    }















































    /*CRMLoginPage loginPage;

    public CRMLoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new CRMLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.login(props.getProperty("username"), props.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {

    }*/

}
