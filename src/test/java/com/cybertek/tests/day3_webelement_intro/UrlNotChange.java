package com.cybertek.tests.day3_webelement_intro;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class UrlNotChange {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String first = driver.getCurrentUrl();
        driver.findElement(By.xpath("//*[@id=\'form_submit\']/i")).click();
        String second = driver.getCurrentUrl();

        if(first.equalsIgnoreCase(second)){
            System.out.println("PASS");
        }else
            System.out.println("FAIL");
        driver.quit();
    }
}