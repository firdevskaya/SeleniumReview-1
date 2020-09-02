import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

    // isDisplayed ==> görüntüleniyor mu anlamında
    // isSelected ==> seçili olup olmadığı
    // isEnabled ==> aktif mi değil mi, işlevsel mi

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Ignore
    @Test
    public void isDisplayed(){


        // bu sitede "Dynamic Controls" yazısı görünüyor mu bunu test edelim
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed(); // true - false
        System.out.println(baslik.getText());
    }

    @Test
    public void isSelected(){
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));

        secimElementi.click();

        // eğer bir webelement seçili ise True değilse False return etmeli
        boolean seciliMi = secimElementi.isSelected();
        System.out.println(seciliMi);
    }

    @Test
    public void isEnabled(){
        WebElement inputKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        boolean aktifMi = inputKutusu.isEnabled(); // true false
        System.out.println("Aktif Mi 1: " + aktifMi);
        WebElement enableButonu = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButonu.click();

        //java kodları çalışırken, istediğniz satırda kodları istediğiniz saniye kadar bekletebiliyorsunuz.
        // bunu Thread.sleep(5000); sağlıyor.
        // sleep altı kırmızı oluyor burada try-catch'i seçerek hatayı gideriyoruz.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean aktifMi2 = inputKutusu.isEnabled(); // true false
        System.out.println("Aktif Mi 2: " + aktifMi2);
    }


}
