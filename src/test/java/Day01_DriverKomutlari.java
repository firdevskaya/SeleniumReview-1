import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {

    @Test
    public void test1(){

        //Chrome driveri kurma
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //driverı tam ekran yaptık
        driver.manage().window().maximize();

        //Webelementlerinin yüklenmesini 10 saniyeye kadar bekletme
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://google.com");

        //Navigate methodları

        //herhangi bir url adresine gitme
        driver.navigate().to("http://amazon.com");

        //bir önceki sayfaya geri dönme
        driver.navigate().back();

        //ileri gider
        driver.navigate().forward();

        //driver'ı kapatmak için kullanılır
        driver.quit();

        //açık olan sekmeyi kapatmak için kullanılır.
        driver.close();
    }
}
