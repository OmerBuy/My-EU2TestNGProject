package com.cybertek.tests.day0Exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWamazon {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.amazon.com");
        driver.navigate().to("http://www.ebay.com");
        WebElement SearchButton = driver.findElement(By.id("gh-ac"));
        SearchButton.sendKeys("search");
        driver.findElement(By.id("gh-btn")).click();
        String title = driver.getTitle();
        System.out.println("Title = "+title);
        driver.quit();


        if(title.contains("search")){
            System.out.println("Title contains 'search'");
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

        }

    }
}
