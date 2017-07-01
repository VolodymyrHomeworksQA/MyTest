package com.myTests.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Admin on 28.12.2016.
 */
public class Task4TestsForPageDemoQARegistration extends ParentClassForTestsClass {

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
    public void FilingOutTheFormPageDemoQARegistration() {
        driver.get("http://demoqa.com/registration/");
        Task4PageDemoQARegistration page = new Task4PageDemoQARegistration(driver);
        page.waitUntilTheElementTextBoxFiledFirstNameIsNotEmpty();
        page.cleansAndFillFiledFirstName("Vasya");
        page.cleansAndFillFiledLastName("Ivanov");
        page.RadioButtonMaritalStatus_Single.click();
        page.RadioButtonHobby_Reading.click();
        page.SelectCountryInComboBox("Ukraine");
        page.SelectDateOfBirth_MonthInComboBox("7");
        page.SelectDateOfBirth_DayInComboBox("7");
        page.SelectDateOfBirth_YearInComboBox("2014");
        page.FillTextBoxPhoneNumber("1234567891");
        page.FillFiledUserName("вася");
        page.FillFiledE_Mail("12345qqq@mail.ru");
        page.FillFiledPassword("cjkywt cdtnbn");
        page.FiledConfirmPassword("cjkywt cdtnbn");
        page.ButtonSubmit.click();
    }
}

