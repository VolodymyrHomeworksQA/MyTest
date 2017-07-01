package com.myTests.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 30.11.2016.
 */
public class Task2PageGoogleTranslator {
    protected final WebDriver driver;
    public Task2PageGoogleTranslator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(xpath = "//*[@id='source']")
    protected WebElement FirstTextBoxForRushWords;
    @FindBy(xpath = "//*[@id='result_box']")
    protected WebElement SecondTextBoxForEnglishWords;
    @FindBy(xpath = "//img[@id='uid_0']")
    protected WebElement picture;
    @FindBy(xpath = "//*[@id=\"rso\"]/div/div[2]/div/h3/a")
    protected WebElement title;

    public void waitUntilTheElementTextBoxIsNotEmpty() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='source']")));
    }

    public void cleansAndFillFieldFirstTextBoxForRushWords(String strWord) {
        FirstTextBoxForRushWords.clear();
        FirstTextBoxForRushWords.sendKeys(strWord);
    }

}
