package com.cybertek.tests.day0Exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MerkezBankasuKuru {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.tcmb.gov.tr/");
        driver.findElement(By.xpath("//a[text()='Bugün']")).click();



    }
}
