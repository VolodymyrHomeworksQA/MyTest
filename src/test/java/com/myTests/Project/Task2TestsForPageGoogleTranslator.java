package com.myTests.Project;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Admin on 30.11.2016.
 */
@RunWith(DataProviderRunner.class)
public class Task2TestsForPageGoogleTranslator extends ParentClassForTestsClass {
    protected WebDriver driver;

    @Before
    public void openSite() {
        //этот код для отключения всплывающего окна
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        // запускаем chromeDriver.exe
        driver.manage().window().maximize();
    }

    @After
    public void closeSite() {
        driver.quit();
    }

    @DataProvider
    public static Object[][] dataProviderAdd()  {
        return new Object[][] {
                    {"товарищь", "comrade"},
                    {"привет", "hi"},
                    {"пока", "as long as"},};
    }

    @Test
    @UseDataProvider("dataProviderAdd")
    public void CheckOneByOneThreeWordTranslation(String Parameter, String expectedResult) {
        driver.get("https://translate.google.com/#ru/en");
        Task2PageGoogleTranslator page = new Task2PageGoogleTranslator(driver);
        page.waitUntilTheElementTextBoxIsNotEmpty();
        page.cleansAndFillFieldFirstTextBoxForRushWords (Parameter);
        Assert.assertTrue("Тест завалился",  page.SecondTextBoxForEnglishWords.getText() == expectedResult);
    }

}
