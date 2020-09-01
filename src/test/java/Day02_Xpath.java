import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        // junit dependency 4.13 versiyonunda üstte static yazmamızı istiyor yoksa hata veriyor.
        // driver'ı kullanılabilir hale getirdik.
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("http://a.testaddressbook.com/");

        //sign in elementini kaç farklı yol ile locate edebiliriz.
        //<a id="sign-in" class="nav-item nav-link" data-test="sign-in" href="/sign_in">Sign in</a>

        //id : evet
        //class : hayır --> arada boşluk var olmaz
        //tagName : evet
        //name : evet
        //xpath : evet
        //cssSelector : evet
        //linkText : evet

        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        //açılan sayfadaki tüm linkleri bulunuz.

        // ipucu: findElements kullanabilirsiniz.
        // ipucu: tagName'i olan webelementler linktir.
        // ipucu: bir sayfadaki tüm webelementleri bulmak istiyorsanız, findElements kullanabilirsiniz.

        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
                                                        // By.xpath("//a"));

        for (WebElement w:tumLinkler) {
            System.out.println(w.getText());


    // cssSelector kullanarak Email, Password ve signIn kutusunu bulunuz
    // i. Username : testtechproed@gmail.com
    //ii. Password : Test1234!

    WebElement userName = driver.findElement(By.cssSelector("#session_email"));
    userName.sendKeys("testtechproed@gmail.com");
    WebElement Password = driver.findElement(By.cssSelector("#session_password"));
    Password.sendKeys("Test1234!");
    WebElement SignIn = driver.findElement(By.cssSelector(".btn.btn-primary"));
    // üstte normalde btn btn-primary  arada boşluk vardı bunu . koyarak düzelttik.
    SignIn.click();

    // F Klavyede : alt + ğ ==> #

    // açılan sayfadaki tüm textleri consola yazdırınız.
    // ipucu :

            // findElements By.xpath("//*") // o sayfadaki tüm webelementlerini bulur.
        /*List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));
        for(WebElement w : tumElementler){
            System.out.println(w.getText());
        }*/
            WebElement tumYazilar = driver.findElement(By.tagName("body"));
            System.out.println(tumYazilar.getText());
        }


    }

    @AfterClass
    public static void tearDown(){
//        driver.quit();
    }

}
