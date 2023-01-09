package day07_dropdown_jsAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {


    //ilgili ayarlari yapin
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {

        //ilgili ayarlari yapin
        // amazon anasayfaya gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in java icerdigini test edin



        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //dropdown menuden isteidigimiz option u secebilmek icin
        // öncelikle select class indan bir obje  olusturmalıyız
        //ancak select objesi olusturmak icin Select classının constructor i
        // handle edecegimiz webelementi istediginden
        //select objesi olusturmadan önce dropdown webelementini locate etmeliyiz


        // arama kutusu yanindaki dropdown menuden book secin
        WebElement dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select classindan obje olusturmak
        Select select=new Select(dropdownWebElementi);

        //3-select objesini kullanarak istedigimiz method/methodlari calistirin

        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);//index 0 dan baslayarak alinir kacinci siradaysa o rakam yazilir
        select.selectByVisibleText("Books");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //System.out.println(driver.getTitle()); ön görmek icin kullanilir

        String expectedKelime="Java";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedKelime)); //if-else i kaldırdık yerine Assert kullaniyoruz


        //dropdown menuden book seceneginin secildigini test edin

        /* Locate ettigimiz elementi bulamazsa NoSuchElementException
        sayfa yenilendigi icin var olan bir elementi kullanmazsa
        StaleElementException verir
        Bu durumda locate ve secme islemi yeniden yaparsak kodumuz calısır
         */

        String actualSecilenOption=select.getFirstSelectedOption().getText();//getFirstSElectedOption=önceki seçilen optionu getir
        String expectedSecilecekOption="Books";

        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);


        //dropdown menudeki secenek sayisinin 28 oldugunu test edin
        List<WebElement>optionsWebElementListesi=select.getOptions();

        int actualoptionsayisi=optionsWebElementListesi.size();
        int exceptedOptionSayisi=28;

        Assert.assertEquals(exceptedOptionSayisi,actualoptionsayisi);


        Thread.sleep(3000);
    }

}
