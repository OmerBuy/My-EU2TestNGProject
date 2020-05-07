package com.cybertek.tests.day0Exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
//        Etsy sitesine gidip arama kismina selenium yazdim. sonra fiyat araligini 15-25 yaptim.
//        sonrasinda cikan urunleri en yuksek fiyattan en dusuk fiyata gore siralayip ilk 3 urunu yazdirdim.
public class ETSYYYY {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.id("global-enhancements-search-query"));
        search.sendKeys("selenium");
        search.sendKeys(Keys.TAB);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("search-filter-min-price-input")).sendKeys("15");
        WebElement search2 = driver.findElement(By.cssSelector("input#search-filter-max-price-input"));
        search2.sendKeys("25");
        //  Thread.sleep(2000);
        search2.sendKeys(Keys.TAB);
        search2.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement ads = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button"));
        ads.click(); //cikan reklami click
        WebElement down = driver.findElement(By.cssSelector("span.etsy-icon.wt-menu__trigger__caret"));//dropdown.click
        down.click();
        //  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/div[2]/button")).click();
        Thread.sleep(2000);
        List<WebElement> elooo = driver.findElements(By.cssSelector("div[role='menu']>a"));
        elooo.get(2).click();//hardcode kullandim,muhtemelen baska yolu vardir

        List<WebElement> list = driver.findElements(By.cssSelector("ul.responsive-listing-grid.wt-grid.wt-grid>li"));
        System.out.println(list.size());
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i).getText());
        }
    }
}