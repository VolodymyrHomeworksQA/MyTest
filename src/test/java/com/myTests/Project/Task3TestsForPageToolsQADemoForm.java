package com.myTests.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Admin on 26.12.2016.
 */
public class Task3TestsForPageToolsQADemoForm extends ParentClassForTestsClass {

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
        public void FilingOutTheFormPageToolsQA() {
            driver.get("http://toolsqa.com/automation%20practice-form/");
            Task3PageToolsQADemoForm page = new Task3PageToolsQADemoForm(driver);
            page.waitUntilTheElementTextBoxIsNotEmpty();
            page.cleansAndFillFiledFirstName("Vasya");
            page.cleansAndFillFiledLastName("Ivanov");
            page.RadioButtonSexMail.click();
            page.RadioButtonYearsOfExperience_One.click();
            page.RadioButtonYearsOfExperience_One.click();
            page.FillTextBoxDate("03/07/16");
            page.RadioButtonProfession_AutomatedTester.click();
            page.RadioAutomationTool_SeleniumWebDriver.click();
            page.SelectContinentInComboBoxContinents("Africa");
            page.OutputInTheConsoleTextOfAllLinks();
        }

    }


