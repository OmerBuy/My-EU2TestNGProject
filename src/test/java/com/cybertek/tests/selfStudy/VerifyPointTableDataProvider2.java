package com.cybertek.tests.selfStudy;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
public class VerifyPointTableDataProvider2 {
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    @DataProvider
    public static Object[] teamNameProvider() {
        return new String[]{"Trabzonspor", "AnkaraGucu", "Galatasaray", "Sivasspor", "Beşiktaş", "Alanyaspor", "Fenerbahçe", "Göztepe", "Gaziantep FK", "Denizlispor", "Antalyaspor", "Gençlerbirliği", "Kasımpaşa", "Konyaspor", "Yeni Malatya", "Ç. Rizespor", "MKE Ankaragücü", "Kayserispor"};
    }
    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(dataProvider = "teamNameProvider")
    public void test(String teamNameFromDP) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mackolik.com/puan-durumu/t%C3%BCrkiye-s%C3%BCper-lig/482ofyysbdbeoxauk19yg7tdt");
        String clubWonCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(6)";
        String clubDeuceCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(7)";
        String clubPointsCSS = "[data-team-name^=\"" + teamNameFromDP + "\"]>td:nth-of-type(12)";
        WebElement clubWon = driver.findElement(By.cssSelector(clubWonCSS));
        WebElement clubDeuce = driver.findElement(By.cssSelector(clubDeuceCSS));
        WebElement clubPoints = driver.findElement(By.cssSelector(clubPointsCSS));
        int won = Integer.parseInt(clubWon.getText().trim());
        int deuce = Integer.parseInt(clubDeuce.getText().trim());
        int point = Integer.parseInt(clubPoints.getText().trim());
        System.out.printf("%s %nPoints :%3d   Won: %3d   Deuce :%3d%n", teamNameFromDP, point, won, deuce);
        Assert.assertEquals(point, ((won * 3) + deuce), teamNameFromDP + " point's is wrong ");
    }
}
