package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hW_6 {
    @Test
    public void test() throws InterruptedException {
        Faker jf = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com");
        WebElement email = driver.findElement(By.xpath("//span[@id='email']"));
        String emailData = email.getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys(jf.name().fullName());
        driver.findElement(By.name("email")).sendKeys(emailData);
        driver.findElement(By.name("wooden_spoon")).click();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualResult,"Thanks for subscribing to practice.cybertekschool.com!");




    }

}
