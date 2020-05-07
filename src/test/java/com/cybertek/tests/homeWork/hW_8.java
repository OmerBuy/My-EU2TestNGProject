package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hW_8 {
    @Test
    public void test() throws InterruptedException {
        Faker jf = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Autocomplete']")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,"You selected: United States of America","Ok you got it verify!!");
    }
}
