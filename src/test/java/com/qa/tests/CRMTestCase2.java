package com.qa.tests;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.pages.CRMAccountSettingsPage;
import com.sel.qa.pages.CRMHomePage;
import com.sel.qa.pages.CRMLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class CRMTestCase2 extends CRMBasePage {

    Logger log = Logger.getLogger(CRMTestCase2.class);

    CRMLoginPage loginPage;

    CRMHomePage homePage;

    CRMAccountSettingsPage accountSettingsPage;

    public CRMTestCase2() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initilization();
        loginPage = new CRMLoginPage();
        homePage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
    }

    @Test
    public void verifyAccountSettingsTest() {

        // 1. Go to Account Settings Page
        accountSettingsPage = homePage.goToAccountSettingsPage();
        //Assert.assertEquals(accountPage.getAccountSettingsHeader(), "Account Settings");

        // 2. Go through each sub menu
        List<WebElement> listSubMenu = accountSettingsPage.getSubMenuLinks();

        for (int i = 0; i < listSubMenu.size(); i++) {
            log.debug(">>> list of sub menu <<<");
            log.debug(listSubMenu.get(i));
            System.out.println("listSubMenu.get(i) >> " + listSubMenu.get(i).getText());
            String header1 = listSubMenu.get(i).getText();
            // 3. click sub menu
            String header2 = accountSettingsPage.clickSubMenu(listSubMenu.get(i));


            // 3.1 compare the headers
            System.out.println("header2 >> " + header2);
            Assert.assertEquals(header1.contains(header2), true);

            // 3.2 inside sub menu, validate task
            List<Map<String, String>> data = accountSettingsPage.validateTask(header2);

            if (data.size() > 0) {
                Assert.assertEquals(data.get(0).equals(data.get(1)), true);
            }

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
