package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class hW_9_12 {
    @Test
    public void test9() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
        String actualResult = driver.findElement(By.xpath("//p[contains(.,'This page returned a 200 status code.')]")).getText();
        Assert.assertTrue(actualResult.contains("This page returned a 200 status code"));
    }
    @Test
    public void test10_11_12() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
        List<WebElement> allcodes = driver.findElements(By.xpath("//div/ul/li"));
        List<String> codes = new ArrayList<>();
        for (WebElement allElement : allcodes) {
            codes.add(allElement.getText());
        }
        for(int i = 0; i < codes.size();i++){
            driver.findElement(By.partialLinkText(codes.get(i))).click();
            String expectedResult = "This page return a "+ codes.get(i).toString() + " status code";
            String actualResult = driver.findElement(By.xpath("//p")).getText();
            System.out.println("actualResult = "+ actualResult);
            System.out.println("expectedResult = " + expectedResult);
            Assert.assertTrue(actualResult.contains(expectedResult),"verify code");
            Thread.sleep(2000);
            driver.quit();
        }

    }

}