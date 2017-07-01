package com.myTests.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 23.11.2016.
 */
public class Task1GooglePage {
    protected final WebDriver driver;

    public Task1GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @FindBy(id = "lst-ib")
    protected WebElement googleTextBox;
    @FindBy(name = "btnG")
    protected WebElement searchButton;
    @FindBy(xpath = "//img[@id='uid_0']")
    protected WebElement picture;
    @FindBy(xpath = "//*[@id=\"rso\"]/div/div[2]/div/h3/a")
    protected WebElement title;

    public void cleansAndFillFieldSearchGoogle(String strPassword) {
        googleTextBox.clear();
        googleTextBox.sendKeys(strPassword);
    }
    public void waitUntilTheElementPictureIsNotEmpty() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@id='uid_0']")));
    }

    public void referenceOutputArray (){
        int urlsCount = driver.findElements(By.xpath("//div/div/div/h3/a")).size();
        List<WebElement> urls = driver.findElements(By.xpath("//div/div/div/h3/a"));
        for (int i=0; i<urlsCount; i++) {
            System.out.println((i+1) + "-я ссылка: " + urls.get(i).getAttribute("href"));
        }
    }



    public void waitUntilTheElementLinkIsNotEmpty() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/div/div/h3/a[@href=\"http://www.andreytkachev.com/\"]")));
    }
    public void waitUntilTheSecondLinkIsNotEmpty(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"rso\"]/div/div[2]/div/h3/a")));
    }

}



