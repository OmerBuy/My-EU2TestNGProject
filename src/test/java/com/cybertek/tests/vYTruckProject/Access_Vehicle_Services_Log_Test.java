package com.cybertek.tests.vYTruckProject;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Access_Vehicle_Services_Log_Test {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider (name = "login")
    public Object [][] loginInfo () {
        return new Object[][]{
                {"User1", "UserUser123"},
                {"User2", "UserUser123"},
                {"User3", "UserUser123"}
        };
    }
    @Test (dataProvider = "login")
    public void test(String username, String password) throws InterruptedException {

        driver.get("http://qa1.vytrack.com/user/login");
        login(username,password);
        driver.findElement(By.xpath("(//span[contains(.,'Fleet')])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Vehicle Services Logs']")).click();
        Thread.sleep(2000);

    }
    public void login (String username, String password){
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn")).click();
    }

}
