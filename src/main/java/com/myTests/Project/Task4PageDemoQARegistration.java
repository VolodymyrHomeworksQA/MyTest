package com.myTests.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 28.12.2016.
 */
public class Task4PageDemoQARegistration {
    protected final WebDriver driver;

    public Task4PageDemoQARegistration(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(xpath = "//input[@id='name_3_firstname']")
    protected WebElement FiledFirstName;
    @FindBy(xpath = "//input[@id='name_3_lastname']")
    protected WebElement FiledLastName;
    @FindBy(xpath = "//input[@name='radio_4[]'][1]")
    protected WebElement RadioButtonMaritalStatus_Single;
    @FindBy(xpath = "//input[@name='checkbox_5[]'][2]")
    protected WebElement RadioButtonHobby_Reading;
    @FindBy(xpath = "//select[@id='dropdown_7']")
    protected WebElement ComboBoxCountry;
    @FindBy(xpath = "//select[@id='mm_date_8']")
    protected WebElement DateOfBirth_Month;
    @FindBy(xpath = "//select[@id='dd_date_8']")
    protected WebElement DateOfBirth_Day;
    @FindBy(xpath = "//select[@id='yy_date_8']")
    protected WebElement DateOfBirth_Year;
    @FindBy(xpath = "//input[@id='phone_9']")
    protected WebElement TextBoxPhoneNumber;
    @FindBy(xpath = "//input[@id='username']")
    protected WebElement FiledUserName;
    @FindBy(xpath = "//input[@id='email_1']")
    protected WebElement FiledE_Mail;
    @FindBy(xpath = "//input[@id='password_2']")
    protected WebElement FiledPassword;
    @FindBy(xpath = "//input[@id='confirm_password_password_2']")
    protected WebElement FiledConfirmPassword;
    @FindBy(xpath = "//input[@name='pie_submit']")
    protected WebElement ButtonSubmit;

    public void waitUntilTheElementTextBoxFiledFirstNameIsNotEmpty() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@id='name_3_firstname']")));
    }


    public void cleansAndFillFiledFirstName(String strWord) {
        FiledFirstName.clear();
        FiledFirstName.sendKeys(strWord);
    }
    public void cleansAndFillFiledLastName(String strWord) {
        FiledLastName.clear();
        FiledLastName.sendKeys(strWord);
    }
    public void FillTextBoxPhoneNumber(String strWord) {
        TextBoxPhoneNumber.sendKeys(strWord);
    }
    public void FillFiledUserName(String strWord) {
        FiledUserName.sendKeys(strWord);
    }
    public void FillFiledE_Mail(String strWord) {
        FiledE_Mail.sendKeys(strWord);
    }
    public void FillFiledPassword(String strWord) {
        FiledPassword.sendKeys(strWord);
    }
    public void FiledConfirmPassword(String strWord) {
        FiledConfirmPassword.sendKeys(strWord);
    }
    public void SelectCountryInComboBox(String strWord) {
        Select oSelect = new Select(ComboBoxCountry);
        oSelect.selectByVisibleText(strWord);
    }
    public void SelectDateOfBirth_MonthInComboBox(String strWord) {
        Select oSelect = new Select(DateOfBirth_Month);
        oSelect.selectByVisibleText(strWord);
    }
    public void SelectDateOfBirth_DayInComboBox(String strWord) {
        Select oSelect = new Select(DateOfBirth_Day);
        oSelect.selectByVisibleText(strWord);
    }
    public void SelectDateOfBirth_YearInComboBox(String strWord) {
        Select oSelect = new Select(DateOfBirth_Year);
        oSelect.selectByVisibleText(strWord);
    }

}

