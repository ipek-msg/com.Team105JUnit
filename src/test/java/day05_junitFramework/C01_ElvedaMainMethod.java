package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test

    public void test01(){
        System.out.println("test01 calıstı");
        //@Test notasyonu sayesinde her bir test method'u bagımsız olarak calısabilir
        //eger testin icerisinde bir assertion yoksa
        //kod problem yasamadan calisip bittiginde
        //JUnit test passed olarak raporlar

    }
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calıstı");
        //@Ignore notasyonu yazildigi test method'unun calıstırılmamasini saglar
        //bu testin çalısmasını istemiyorsak @Ignore koyarız
    }

    @Test
    public void test03(){
        System.out.println("test03 calıstı");
    }
}
