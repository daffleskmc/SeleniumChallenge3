package com.sel.qa.base;

import com.sel.qa.util.CRMUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CRMBasePage {

    public static Properties props;

    public static WebDriver driver;


    public CRMBasePage() {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\config\\crmconfig.properties");
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initilization() {
        String browser = props.getProperty("browser");

        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(CRMUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(CRMUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));
    }



























//    public static Properties props;
//
//    public static WebDriver driver;
//
//    public CRMBasePage() {
//        props = new Properties();
//
//        try {
//            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\sel\\qa\\config\\crmconfig.properties");
//            props.load(fis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void initialization() {
//        String browser = props.getProperty("browser");
//
//        if (browser.equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(CRMUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(CRMUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
//        driver.get(props.getProperty("url"));
//    }


}
