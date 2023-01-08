package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
      JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
      Ancak raporlamanin dogru sonuc vermesi icin
      Test'lerin Assert class'indaki hazir method'larla yapilmasi gerekir.
      Eger Assert class'i kullanilmazsa
      JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
      C01'de testleri if-else ile yaptigimiz icin
      Testler failed olsa da kodlar sorunsuz calistigi icin
      testler yesil tik olarak isaretlendi
    */
    int yas1 = 60;
    int yas2 = 66;
    int yas3 = 70;

    @Test
    public void test01() {

        //emekli yasi 65 olduguna gore
        //yas2'nin emekli olabilegini test edin
        Assert.assertTrue(yas2 > 65);
    }

    @Test
    public void test02() {
        //emekli yasi 65 olduguna gore
        //yas1'nin emekli olamayacagini test edin
        Assert.assertFalse(yas1 > 65);
    }

    @Test
    public void test03() {
        //emekli yasi 65 olduguna gore
        //yas3'nin emekli olamayacagini test edin
        Assert.assertFalse("girilen yas 65'den kucuk olmadigindan emekli olabilir", yas3 > 65);
    }
}
