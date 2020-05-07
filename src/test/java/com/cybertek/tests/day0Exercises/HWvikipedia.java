package com.cybertek.tests.day0Exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HWvikipedia {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.cssSelector("[data-jsl10n=search-input-button]")).click();
        driver.findElement(By.cssSelector("[title='Selenium (software)']")).click();
        String actualUrl = driver.getCurrentUrl();
        driver.quit();
        if(actualUrl.endsWith("Selenium_(software)")){
            System.out.println("PASS");
            System.out.println("Url ends with `Selenium_(software)'");
        }else{
            System.out.println("FAIL");
            System.out.println("Url does not ends with `Selenium_(software)'");
        }
    }
}
