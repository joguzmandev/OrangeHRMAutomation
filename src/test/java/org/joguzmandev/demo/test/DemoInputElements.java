package org.joguzmandev.demo.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.TakeScreenShotHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoInputElements {
    private WebDriver webDriver;

    @BeforeTest
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://formy-project.herokuapp.com/form");
    }

    @Test
    public void test_count_inputs(){
        List<WebElement> elements = webDriver.findElements(By.tagName("input"));
        JavascriptExecutor executor = ((JavascriptExecutor)webDriver);
        elements.forEach(webElement -> {
            TakeScreenShotHelper.takeScreenshot(webElement.getText(),webDriver);
        });
        Assert.assertEquals(10, elements.size(), "all inputs not found it");
    }

    @AfterTest
    public void dispose(){
       // webDriver.close();
    }
}
