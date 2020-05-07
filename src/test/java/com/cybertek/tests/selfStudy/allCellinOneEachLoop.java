package com.cybertek.tests.selfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class allCellinOneEachLoop {
    @Test
    public void cellByCell() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");

        List<WebElement> titles = driver.findElements(By.xpath("(//tr)[1]/th"));
        //titles  = toplam 6 element( buradan getText ile basliklari alacagiz

        List<WebElement> allCells = driver.findElements(By.xpath("(//tbody)[1]//tr//td"));
        //allCells = toplam 24 element (buradan getText ile hucrelerin icindeki datayi teker teker alacagiz

        Iterator<WebElement> titleIter = titles.iterator();
        // titleIter.next() basliklari teker teker yazdirmamiza yarayacak (.getText() ile)
        //


        for (WebElement cell : allCells) {// 24 hucreyi liste seklinde barindiran allCells icin for each loop kuruyoruz

            String title = titleIter.next().getText();//-1. indexten 0 git ve text'ini al=(lastName)

            if (titleIter.hasNext() == false) {


                System.out.println("----action-edit yazilmadi,  ----\n" +
                        " ---siradaki kisi bilgilerine geciyoruz---");

                titleIter = titles.listIterator();//pointer tekrar -1 e dondu
                continue;
            } else
                System.out.printf("%-13S :%s\n", title, cell.getText());
        }
    }
}
