package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class hW_1_5 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Testcase1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        WebElement input_dob = driver.findElement(By.xpath("//input[@name='birthday']"));
        input_dob.sendKeys("222222222");
        String actualResult = driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        String expectedResult="The date of birth is not valid.";
       // actualResult.equals(expectedResult);
        Assert.assertEquals(actualResult,expectedResult,"Verify that warning message is displayed:");
    }

    @Test
    public void Testcase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        List<WebElement> elements = driver.findElements(By.className("form-check-label"));
        Assert.assertTrue(elements.get(0).isDisplayed());
        Assert.assertTrue(elements.get(1).isDisplayed());
        Assert.assertTrue(elements.get(2).isDisplayed());


       /* WebElement cplus = driver.findElement(By.cssSelector("[for='inlineCheckbox1']"));
        Assert.assertTrue(cplus.isDisplayed());
        WebElement Java = driver.findElement(By.cssSelector("[for='inlineCheckbox2']"));
        Assert.assertTrue(Java.isDisplayed());
        WebElement JavaScript = driver.findElement(By.cssSelector("[for='inlineCheckbox3']"));
        Assert.assertTrue(JavaScript.isDisplayed());*/



    }
    @Test
    public void Testcase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement warning = driver.findElement(By.xpath("//small[@data-bv-validator='stringLength']"));
        String msg = warning.getText();
        Assert.assertEquals(msg,"first name must be more than 2 and less than 64 characters long");


    }
    @Test
    public void Testcase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("a");
        WebElement warning = driver.findElement(By.tagName("small"));
        String msg = warning.getText();
        Assert.assertEquals(msg,"The last name must be more than 2 and less than 64 characters long");

    }
    @Test
    public void Testcase5() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("omer");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("buyruk");
        driver.findElement(By.name("//input[@name='username']")).sendKeys("cybertek");
        driver.findElement(By.name("//input[@name='password']")).sendKeys("12345678");
    }
}