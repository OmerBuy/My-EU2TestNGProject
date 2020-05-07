package com.cybertek.tests.selfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class mackolik {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterClass
    public void finish() throws InterruptedException {
        Thread.sleep(2000);
        //   driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/482ofyysbdbeoxauk19yg7tdt");
       // List<WebElement> toplamTakimlar = driver.findElements(By.xpath("//tbody/tr"));
        List<WebElement> clubNames = driver.findElements(By.xpath("//tbody//tr//td[3]"));
        List<WebElement> clubPoints = driver.findElements(By.xpath("//tbody//tr//td[12]"));
        for (int i = 0; i < clubNames.size(); i++) {
            System.out.println(clubNames.get(i).getText() + " " + clubPoints.get(i).getText() + "Puan");
        }

      /*  for (WebElement tekTakim : toplamTakimlar) {
            String result = tekTakim.getText();
            String[] resultArray = result.split(" ");
           // System.out.println(tekTakim.getText());
            System.out.print(resultArray[1]+" ");
            System.out.println(resultArray[9]);
           // System.out.println("result = " + result);
        }*/
    }
}