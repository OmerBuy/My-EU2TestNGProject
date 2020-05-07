package com.cybertek.tests.day0Exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWebay {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
        WebElement SearchButton = driver.findElement(By.id("gh-ac"));
        SearchButton.sendKeys("search");
        SearchButton.sendKeys(Keys.TAB);
        SearchButton.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//h1[text()=' results for ']"));
        System.out.println(result.getText());
        driver.quit();


    }
}
