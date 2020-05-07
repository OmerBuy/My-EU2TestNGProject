package com.cybertek.tests.day5_xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * TASK
         * go to amazon.com
         * search for selenium
         * click search button
         * print 1-48 of 304 results for "selenium"
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.com/");
        WebElement SearchButton = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        SearchButton.sendKeys("selenium");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[contains(@value,'Go')]")).click();
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        System.out.println("result.getText() = "+result.getText());

        driver.quit();



    }
}
