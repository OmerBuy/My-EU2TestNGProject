package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hW_7 {

    @Test
    public void test() throws InterruptedException {
        Faker jf = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.xpath("//a[.='File Upload']")).click();
        // driver.findElement(By.xpath("//div[@class='dz-success-mark dz-clickable']")).click();
        // driver.findElement(By.xpath("//div[@class='dz-success-mark dz-clickable']")).sendKeys("C:\\Users\\35844\\Desktop\\Test-Automation\\day-11");
        driver.findElement(By.xpath("//form[@method='POST']/input[1]")).sendKeys("C:\\Users\\35844\\Desktop\\Test-Automation\\day-11");
        driver.findElement(By.id("file-submit")).click();
        String actualResult = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualResult,"day-11","Verify that uploaded file name is displayed.");
    }
}