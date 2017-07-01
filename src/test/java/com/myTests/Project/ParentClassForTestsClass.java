package com.myTests.Project;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public  class ParentClassForTestsClass {

        @BeforeClass
    public static void pathOfTheDriver () {

        // знакомии chromeDriver.exe   IntelliJ IDEA
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\external\\chromedriver.exe");



    }
}
















