package com.myTests.Project;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//@RunWith(JUnit4.class)

public class Task5_2TestsForPageAngelNet extends ParentClassForTestsClass {
    protected WebDriver driver;
    protected Task5_2PageAngelNet pg;
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
    @Rule
   public RepeatRule rule = new RepeatRule();

    @Test
    @Repeat (times = 2)
    public void CheckTheReliabilityOfTheGeneratedPassword () {
            driver.get("http://angel.net/~nic/passwd.current.html");
            pg = new Task5_2PageAngelNet(driver);
            pg.cleansAndFillFieldYouMasterPassword("jctyybq lj;lm");
            pg.cleansAndFillFieldSiteName("https://bitbucket.org/");
            pg.buttonGenerate.click();
            pg.waitUntilTheFiledIsNotEmpty();
            Assert.assertFalse("Тест завалился", pg.generatedPassword.getText()=="fIO79phsJ1b");
    }
}
