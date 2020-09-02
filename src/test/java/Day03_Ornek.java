import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // 1.Dropdown da Books kategorisini seçelim
    // 2.Arama kutusuna JAVA yazalım
    // 3.Toplam sonuç sayısını ekrana yazdıralım.
    // 4. İlk sıradaki ürüne tıklayalım.
    // 5. Back to results linki varsa, testimiz TRUE yoksa FALSE
    @Test
    public void amazonDropdownTest(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("JAVA" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//span[.='1-16 of over 20,000 results for']"));
        System.out.println(sonuc.getText());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement ilkUrun = driver.findElement(By.xpath("//span[.='Effective Java']"));
        ilkUrun.click();

        WebElement back = driver.findElement(By.linkText("Back to results"));
        boolean backVarmi = back.isEnabled();
        Assert.assertTrue(backVarmi);

    }
}
