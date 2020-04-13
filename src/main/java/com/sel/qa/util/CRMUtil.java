package com.sel.qa.util;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CRMUtil {

    Logger log = Logger.getLogger(CRMUtil.class);

    public static long PAGE_LOAD_TIMEOUT = 30;

    public static long IMPLICIT_TIMEOUT = 40;

    public static Workbook book;
    public static Sheet sheet;
    public static JavascriptExecutor js;

    public static Object[][] getTestData(String filePath, String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//         System.out.println(sheet.getLastRowNum() + "--------" +
//         sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//                 System.out.println(data[i][k]);
            }
        }
        return data;
    }

/*    public static Object[][] getTestDataWithMapReturn(String filePath, String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//         System.out.println(sheet.getLastRowNum() + "--------" +
//         sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Map<Object, Object> datamap = new HashMap<Object, Object>();
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                datamap.put(sheet.getRow(0).getCell(k).toString(), sheet.getRow(i+1).getCell(k).toString());
                *//*data[i][k] = sheet.getRow(i + 1).getCell(k).toString();*//*
                data[i][k] = datamap;
//                 System.out.println(data[i][k]);
            }
        }
        return data;
    }*/

    public static void selectFromDropdown(WebDriver driver, By byTitle, String element) {
        List<WebElement> listTitle = driver.findElements(byTitle);

        Iterator<WebElement> it = listTitle.iterator();
        while(it.hasNext()) {
            WebElement el = it.next();
            if (el.getText().equalsIgnoreCase(element)) {
                el.click();
                break;
            }
        }
    }

/*    public static void selectFromDropDown(WebDriver driver, By by, String element) {
        List<WebElement> list = driver.findElements(by);
//        System.out.println(">> list size: " + listTitle.size());
        Iterator<WebElement> it = list.iterator();
        while (it.hasNext()) {
            WebElement el = it.next();
            if (el.getText().equalsIgnoreCase(element)) {
                el.click();
                break;
            }
        }
    }*/

    public static void scrollToBottomOfPage(WebDriver driver) {
        try {
            long Height = Long.parseLong(
                    ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

                Thread.sleep(3000);

                long newHeight = Long.parseLong(
                        ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

                if (newHeight == Height) {
                    break;
                }
                Height = newHeight;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // Scrolls to top of page
    public static void scrollToTopOfPage(WebDriver driver) {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");

    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTilPresent(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // different way to read excel data
    //Reads Excel file, and return a list of maps, maps are generated for each row
    public static List<Map<String, String>> getTestDataWithMapReturn(String TestCase, String filePath)
    {
        List<Map<String, String>> data=new ArrayList<Map<String, String>>();

        //File file=new File(ReadPropertyFile.get("inputData"));
        File file = new File(filePath);
        try {
            FileInputStream fis=new FileInputStream(file);
            book=new XSSFWorkbook(fis);
            sheet=book.getSheet(TestCase.toUpperCase());
            int rows=sheet.getLastRowNum();
            for(int i=1;i<=rows;i++)
            {
                Row row=sheet.getRow(i);
                int columns=row.getLastCellNum();
                Map<String, String> temp=new HashMap<String,String>();
                for(int j=0;j<columns;j++)
                {

                    DataFormatter formatter = new DataFormatter();
                    String val = formatter.formatCellValue(row.getCell(j));
                    temp.put(formatter.formatCellValue(sheet.getRow(0).getCell(j)).toUpperCase(), val);

                }
                data.add(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                book.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return data;
    }


    public static By getDynamicXpath(String xpath,String data)
    {
        String rawXpath=xpath.replaceAll("%replaceable%", data);
        System.out.println(rawXpath);
        return By.xpath(rawXpath);
    }

    public static void checkIfPopupIsPresent(WebDriver driver, WebElement element) {
        Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows
        String mwh=driver.getWindowHandle();
        /*System.out.println(">>> mwh? " + mwh);*/
        Iterator ite=s.iterator();
        /*System.out.println("ite has next? " + ite.hasNext());*/
        while(ite.hasNext())
        {
            String popupHandle=ite.next().toString();
            /*System.out.println("popupHandle ------- " + popupHandle);*/
            if(popupHandle.contains(mwh))
            {
                /*System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");*/
                driver.switchTo().window(popupHandle);
                //here you can perform operation in pop-up window**
                element.click();
                //After finished your operation in pop-up just select the main window again
                //driver.switchTo().window(mwh);
            }
        }
    }

    //Extracts data from table, and returns in a list
    public static List<String> getData(By xpath,WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> tds=driver.findElements(xpath);
        List<String> fetchedData=new ArrayList<String>();
        for(int i=0;i<tds.size();i++)
        {
            fetchedData.add(tds.get(i).getAttribute("innerText").trim());
            //System.out.println(i+"+"+Arrays.toString((tds.get(i).getAttribute("innerText").trim().split("\n"))));
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return fetchedData;

    }
}
