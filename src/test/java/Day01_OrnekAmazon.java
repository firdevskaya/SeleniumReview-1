import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {

    // 1. Amazon.com'a git
    // 2. arama kutusunana "baby stroller"
    // 3. 2.sıradaki ürüne tıklayacağız.
    // 4. Ürün sayfasına gittikten sonra ürünün toplam fiyatını al.

    WebDriver driver;
    @Test
    public void test1(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().window().maximize();
  //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

    WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("baby stroller" + Keys.ENTER);

    WebElement ikinciUrun = driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]"));
    ikinciUrun.click();

    WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice"));
    String fiyat = urunFiyati.getText();
        System.out.println(fiyat);

    // 1. google.com'a navigate().to() kısmına geçiş yapalım
    // 2. "kemal ozden" yazıp arama yapalım
    // 3. karşımıza çıkan sonuç sayısını ekrana yazdıralım.

       driver.navigate().to("http://google.com");
    WebElement googleAramaKutusu = driver.findElement(By.name("q"));
        googleAramaKutusu.sendKeys("Kemal Ozden");
        googleAramaKutusu.submit();
    WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
}




}
