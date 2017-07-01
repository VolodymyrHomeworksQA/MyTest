package com.myTests.Project;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Admin on 23.11.2016.
 */
public class Task1VovaInGoogleSearch extends ParentClassForTestsClass {
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

        @Test
        public void Task1_1WeFindTheSecondPictureFoundOnRequest() {
        driver.get("https://www.google.com.ru");
            Task1GooglePage page = new Task1GooglePage(driver);
            page.cleansAndFillFieldSearchGoogle("вова");
            page.searchButton.click();
            page.waitUntilTheElementPictureIsNotEmpty();
            Assert.assertTrue("Его НЕЕЕЕЕЕЕЕЕЕТ", !driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).isEmpty());
            page.picture.click();
         }

        @Test
        public void Task1_2CheckTheSecondLinkToThePresenceOfTheKeyword() {
            driver.get("https://www.google.com.ua");
            Task1GooglePage page = new Task1GooglePage(driver);
            page.cleansAndFillFieldSearchGoogle("ткачёв");
            page.searchButton.click();
            page.waitUntilTheSecondLinkIsNotEmpty();
            Assert.assertTrue("Тест завалился", driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")).getText().contains("Проповеди"));
        }

        @Test
        public void Task1_3CheckTheSecondLink() {
            driver.get("https://www.google.com.ua");
            Task1GooglePage page = new Task1GooglePage(driver);
            page.cleansAndFillFieldSearchGoogle("ткачёв");
            page.searchButton.click();
            Assert.assertTrue("Тест завалился", page.title.getText().length() >= 9);
            Assert.assertTrue("Тест завалился", page.title.getAttribute("href").equals("http://www.andreytkachev.com/"));
        }

        @Test
        public void Task1_4WeFindTheSecondLinkFoundOnRequest() {
            driver.get("https://www.google.com.ua");
            Task1GooglePage page = new Task1GooglePage(driver);
            page.cleansAndFillFieldSearchGoogle("ткачёв");
            page.searchButton.click();
            page.waitUntilTheElementLinkIsNotEmpty();
            page.referenceOutputArray();
        }




    }


