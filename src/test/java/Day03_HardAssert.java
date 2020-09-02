import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
    }

    @Test
    public void test(){

        String baslik = driver.getTitle();

        // site baslığı içinde "Car" kelimesi geçiyor mu bakalım
        if(baslik.contains("Car")){
            System.out.println("Geçiyor :" + baslik);
        }else {
            System.out.println("Geçmiyor : " + baslik);
        }
        // üstteki gibi bir sorgulamada FALSE da olsa TRUE da olsa selenium her zaman PASS verecektir.
        // Testimizin başarılımı değil mi bunu görebilmek için Assertion methodu kullanılıyor.

        boolean iceriyorMu = baslik.contains("Car");
        Assert.assertTrue(iceriyorMu); // TRUE olduğunu doğrula
    }
    // Sayfa başlığında "Google" kelimesi geçmiyorsa test başarılı bunu kontrol edelim
    @Test
    public void test2(){
        String baslik = driver.getTitle();
        Assert.assertFalse(driver.getTitle().contains("Google"));

        // iki farklı değeri karşılaştırıyorsunuz
        // expected ve actaul değerler aynı mı karşılaştırmak için kullanılır.
        // beklentimiz "Amazon.com" actual değer baslik

        Assert.assertEquals("Amazon.com", baslik);
    }

    @Test
    public void softAssertTest(){
        // softAssert classından nesne üretmek durumundayız
        // Test fail olsa bile çalışmaya devam eder.
        // JUnit'tte softAssert yok TestNg'de var.




    }
}
