package day08_HandLingWindow;

import org.junit.Test;
import utilitles.ReusableMethods;
import utilitles.TestBase;

public class C04_TestBaseIlkTest extends TestBase {
    //direkt olarak url'e ulaşmak istiyoruz bunun için
    // ilk önce javadan bir package oluşturalım
    //adını utilitles koyduk ve içine bir test base classı açtık
    //Test Base in içine her zaman kullandıgımız before after methodlarımızı içerisindeki bilgilerle yerleştirdik
    //artık public classımızın yanına extends TestBase yazmamız parent imiza ulaşmak için yeterli olacaktir
    //fakat classımızdaki driverların çalışması için son bir ayara daha ihtiyacımız var
    //buda TestBase classımızdaki WebDriver driver; in başına protected yazmaktir böylece parentimizdaki bilgileri artık
    //diğer classlarimizda da kullanabileceğiz


    //bir diger ayar ise Thread.sleep ayari
    //bu ayar içinde ReusableMEthods adinda  bir class açıyoruz
    //içine ilgili ayarlari kaydediyoruz
    //ve kullanacağımız classa ReusableMethod.bekle(); yazmamiz yeterli oluyor
    //böylece her seferinde publice exception göndermekten kurtulmuş olduk

    @Test
    public void test01(){

        //amazon'a gidin
         driver.get("https://www.amazon.com");

         //amazona gittiginizi test edin

        ReusableMethods.bekle(3);


    }
}