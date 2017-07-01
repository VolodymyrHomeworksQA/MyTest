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
 * Created by Admin on 20.12.2016.
 */
public class Task3PageToolsQADemoForm {
    protected final WebDriver driver;

    public Task3PageToolsQADemoForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    protected WebElement FiledFirstName;
    @FindBy(xpath = "//input[@name='lastname']")
    protected WebElement FiledLastName;
    @FindBy(xpath = "//input[@id='sex-0']")
    protected WebElement RadioButtonSexMail;
    @FindBy(xpath = "//input[@id='exp-0']")
    protected WebElement RadioButtonYearsOfExperience_One;
    @FindBy(xpath = "//input[@id='datepicker']")
    protected WebElement FiledDate;
    @FindBy(xpath = "//input[@id='profession-1']")
    protected WebElement RadioButtonProfession_AutomatedTester;
    @FindBy(xpath = "//input[@id='tool-2']")
    protected WebElement RadioAutomationTool_SeleniumWebDriver;
    @FindBy(xpath = "//select[@id='continents']")
    protected WebElement ComboBoxContinents;


    public void waitUntilTheElementTextBoxIsNotEmpty() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@name='firstname']")));
    }

    public void OutputInTheConsoleTextOfAllLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//form/fieldset/div[@class=\"control-group\"]/a"));
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }
    }

    public void cleansAndFillFiledFirstName(String strWord) {
        FiledFirstName.clear();
        FiledFirstName.sendKeys(strWord);
    }

    public void cleansAndFillFiledLastName(String strWord) {
        FiledLastName.clear();
        FiledLastName.sendKeys(strWord);
    }

    public void FillTextBoxDate(String strWord) {
        FiledDate.sendKeys(strWord);
    }

    public void SelectContinentInComboBoxContinents(String strWord) {
        Select oSelect = new Select(ComboBoxContinents);
        oSelect.selectByVisibleText(strWord);
    }
}