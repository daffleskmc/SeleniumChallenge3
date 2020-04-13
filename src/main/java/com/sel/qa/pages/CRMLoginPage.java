package com.sel.qa.pages;

import com.sel.qa.base.CRMBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMLoginPage extends CRMBasePage {

    @FindBy(id="login:usernameDecorate:username")
    WebElement username;

    @FindBy(id="login:passwordDecorate:password")
    WebElement password;

    @FindBy(id="login:login")
    WebElement submitBtn;

    public CRMLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public CRMHomePage login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);

        submitBtn.click();

        return new CRMHomePage();
    }




















































/*    @FindBy(id = "login:usernameDecorate:username")
    WebElement username;

    @FindBy(id = "login:passwordDecorate:password")
    WebElement password;

    @FindBy(id = "login:login")
    WebElement loginBtn;

    public CRMLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public CRMHomePage login(String uname, String pwd) {

        username.sendKeys(uname);
        password.sendKeys(pwd);

        loginBtn.click();

        return new CRMHomePage();
    }*/

}
