package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import com.sel.qa.util.CRMUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRMAccountSettingsPage extends CRMBasePage {

    @FindBy(xpath = "//h1[@class='sp-portal__title']")
    WebElement accountSettingsHeader;

/*    @FindBy(xpath = "//h4[@class='sp-portal__item-title' and contains(text(), 'Account and Plan')]")
    WebElement accountPlanLink;*/

    @FindBy(xpath = "//h4[@class='sp-portal__item-title']")
    List<WebElement> accountSettingsSubMenu;

    @FindBy(xpath = "//input[@id='appearance:uploadDecorate:logoImage']")
    List<WebElement> chooseFile;

    @FindBy(xpath = "//a[contains(text(),'Save')]")
    WebElement saveBtn;

//    @FindBy(xpath = "//h1[@class='sp-page__title']")
    @FindBy(xpath = "//*[@class='sp-page__title']") // used * because othe sub menu is using h1 or h2, etc
    WebElement subMenuHeader;

//    @FindBy(xpath = "//a[@href='/settings']")
//    @FindBy(xpath = "//a[@href='/settings' and text()='Account Settings' and @data-pendo-guide='show-breadcrumbs-guide']")
    @FindBy(xpath = "//a[@href='/settings' and contains(text(),'Account Settings') and @data-pendo-guide='show-breadcrumbs-guide']")
    WebElement accountSettingsLink;

    @FindBy(xpath = "//*[contains(text(), 'Add new')]")
    List<WebElement> addNewBtn;

    @FindBy(xpath = "//*[contains(text(), 'Configure')]")
    List<WebElement> configureBtn;

    String dynamicXpathUser = "//a[contains(text(), '%replaceable%')]";

    String opportunityXpath="//*[contains(.,'%replaceable%')]/ancestor::tr/child::td";

    public CRMAccountSettingsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getAccountSettingsHeader() {
        return accountSettingsHeader.getText();

    }

    public List<WebElement> getSubMenuLinks() {
        //accountSettingsSubMenu = driver.findElements(By.xpath("//h4[@class='sp-portal__item-title']"));
        return accountSettingsSubMenu;
    }

    // given: this method will be called once page is in the sub menu already
    public List<Map<String, String>> validateTask(String subMenu) {
        System.out.println("inside validateTask()");
        List<Map<String, String>> map = new ArrayList<Map<String, String>>();

        // 1. check if sub menu has 'Choose File'
        if (subMenu.equalsIgnoreCase("Appearance")) {
            // the sub menu 'Appearance has Choose File'
            chooseFile.get(0).sendKeys(System.getProperty("user.dir") + props.getProperty("logo"));
            saveBtn.click();
        }
        else if (addNewBtn.size() > 0) {

            List<Map<String, String>> data;

            if (subMenu.equalsIgnoreCase("Users")) {
//                data = new CRMUsers(driver).addUser();
//
//                for (int i = 0; i < data.size(); i++) {
//                    Map<String, String> mapData = data.get(i);
//                    By xpath = CRMUtil.getDynamicXpath(dynamicXpathUser, mapData.get("FIRSTNAME") + " " + mapData.get("LASTNAME"));
//                    List<String> fetchedData = CRMUtil.getData(xpath, driver);
//                    Map<String, String> userData = new HashMap<String, String>();
//                    userData.put("FIRSTNAME", fetchedData.get(i).split(" ")[0]);
//                    userData.put("LASTNAME", fetchedData.get(i).split(" ")[1]);
//
//                    map.add(userData);
//
//                }
//                return map;
//                map.add(mapData);

                // commented above as only two users are allowed
                // use below to proceed with rest of subMenu
                CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
                accountSettingsLink.click();
            }
            else if (subMenu.equalsIgnoreCase("Opportunities")) {
//                data = new CRMOpportunities(driver).addMilestone();
//
//                for(int i = 0; i < data.size(); i++) {
//                    Map<String, String> mapData = data.get(i);
//                    By xpath = CRMUtil.getDynamicXpath(opportunityXpath, mapData.get("NAME"));
//                    List<String> fetchedData = CRMUtil.getData(xpath, driver);
//                    System.out.println("size of fetchedData: " + fetchedData.size());
//                    Map<String, String> oppData = new HashMap<String, String>();
//                    oppData.put("NAME", fetchedData.get(i).split("\n")[0]);
//
//                    map.add(oppData);
//                }
//                return map;
//                map.add(mapData);

                // commented above as only two users are allowed
                // use below to proceed with rest of subMenu
                CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
                accountSettingsLink.click();
            }

            else if (subMenu.equalsIgnoreCase("Tracks")) {
//                data = new CRMTracks(driver).addTracks();
//
//                for(int i = 0; i < data.size(); i++) {
//                    Map<String, String> mapData = data.get(i);
//                    By xpath = CRMUtil.getDynamicXpath(dynamicXpathUser, mapData.get("NAME"));
//                    List<String> fetchedData = CRMUtil.getData(xpath, driver);
//                    Map<String, String> trackData = new HashMap<String, String>();
//                    trackData.put("NAME", fetchedData.get(0));
//
//                    map.add(trackData);
//                }
//                return map;
//                map.add(mapData);

                // commented above as only two users are allowed
                // use below to proceed with rest of subMenu
                CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
                accountSettingsLink.click();
            }
            else if (subMenu.equalsIgnoreCase("Task Categories")) {
//                data = new CRMTaskCategories(driver).addTask();
//
//                for(int i = 0; i < data.size(); i++) {
//                    Map<String, String> mapData = data.get(i);
//                    By xpath = CRMUtil.getDynamicXpath(dynamicXpathUser, mapData.get("NAME"));
//                    List<String> fetchedData = CRMUtil.getData(xpath, driver);
//                    Map<String, String> taskData = new HashMap<String, String>();
//                    taskData.put("NAME", fetchedData.get(0));
//
//                    map.add(taskData);
//                    map.add(mapData);
//                }
//                return map;

                // commented above as only two users are allowed
                // use below to proceed with rest of subMenu
                CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
                accountSettingsLink.click();
            }

            else if (subMenu.equalsIgnoreCase("Tags and DataTags")) {
//                data = new CRMTags(driver).addTag();
//
//                for (int i = 0; i < data.size(); i++) {
//                    Map<String, String> mapData = data.get(i);
//                    By xpath = CRMUtil.getDynamicXpath(dynamicXpathUser, mapData.get("NAME"));
//                    List<String> fetchedData = CRMUtil.getData(xpath, driver);
//                    Map<String, String> tagData = new HashMap<String, String>();
//                    tagData.put("NAME", fetchedData.get(0));
//
//                    map.add(tagData);
//                    map.add(mapData);
//                }
//
//                return map;

                // commented above as only two users are allowed
                // use below to proceed with rest of subMenu
                CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
                accountSettingsLink.click();
            }
        }

        else if (configureBtn.size() > 0) {
            Map<String,String> mapExpected = new HashMap<String, String>();
            mapExpected.put("NUMBER", "11");

            Map<String, String> mapActual = new HashMap<String, String>();
            mapActual.put("NUMBER", configureBtn.size()+"");

            map.add(mapExpected);
            map.add(mapActual);
        }
        else {
            System.out.println("inside else...");
            CRMUtil.waitForElementToBeClickable(driver, accountSettingsLink);
            accountSettingsLink.click();
        }

        return map;
    }

    //Clicks on Menu based on Menu element provided
    public String clickSubMenu(WebElement accountSettingsSubMenu)
    {
        String str = accountSettingsSubMenu.getText();
        CRMUtil.waitForElementToBeClickable(driver, accountSettingsSubMenu);
        accountSettingsSubMenu.click();
//        new CRMAccountSettingsPage();
        CRMUtil.waitForElementToBeVisible(driver, subMenuHeader);

//        System.out.println("str: " + str);
//        System.out.println("subMenuHeader: " + subMenuHeader.getText());

        return subMenuHeader.getText();
//        return subMenuData;

//        String a=menu.getText();
//        log.debug("Clicked on Menu "+a);
//        ExplicitWait.waitTillClickable(menu, driver);
//        menu.click();
//        new AccountSettings(driver);
//        ExplicitWait.waitTillvisible(pageTitle, driver);
//        String[] menuData= {a,pageTitle.getText()};
//        return menuData;
    }

}
