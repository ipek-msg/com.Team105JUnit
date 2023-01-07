package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    //3 farklı test methodu olusturun
    //her bir methodun basında driver olusturup
    //1. method amazon.com
    //2. method wisequarter.com
    //3. method youtube.com a gidip
    //title lari yazdirin ve method dan sonra driveri kapatın

    WebDriver driver;
    @Before
    //her methodun başında istediği için driverlari @Before yaptık
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    //her method sonrası close istedigi icin @After yazdık
    public void tearDown(){
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);



    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
}
