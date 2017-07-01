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

public class Task5_2PageAngelNet {
  protected final WebDriver driver;

  public Task5_2PageAngelNet(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }
  @FindBy(xpath = "//input[@name='master']")
  private WebElement youMasterPassword;
  @FindBy(xpath = "//input[@name='site']")
  private WebElement siteName;
  @FindBy(xpath = "//input[@name='password']")
  WebElement generatedPassword;
  @FindBy(xpath = "//input[@type='submit']")
  WebElement buttonGenerate;

  public void cleansAndFillFieldYouMasterPassword(String strPassword) {
    youMasterPassword.clear();
    youMasterPassword.sendKeys(strPassword);
  }

  public void cleansAndFillFieldSiteName(String strSiteName) {
    siteName.clear();
    siteName.sendKeys(strSiteName);
  }

  public void waitUntilTheFiledIsNotEmpty() {
    Wait<WebDriver> wait = new WebDriverWait(driver, 3, 1000).withMessage("Element was not found");
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//input[@name='password']"), generatedPassword.getText() ));
  }
}


