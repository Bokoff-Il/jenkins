package bokoff.il.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("test6")
public class SystemPropertiesTests {

  @Test
  void test1(){
    String browser = System.getProperty("browser");
    System.out.println(browser);
  }

@Test
  void test2(){
    System.setProperty("browser","safari");
    String browser = System.getProperty("browser");
    System.out.println(browser);
  }

@Test
  void test3(){
    String browser = System.getProperty("browser", "chrome");
    System.out.println(browser);
  }
@Test
  void test4(){
  System.setProperty("browser","safari");
    String browser = System.getProperty("browser", "chrome");
    System.out.println(browser);
  }

@Test
@Tag("test5")
  void test5(){
    String browser = System.getProperty("browser", "chrome");
    String version = System.getProperty("version", "100");
    String browserSize = System.getProperty("browserSize", "1920x1080");
    System.out.println(browser);
    System.out.println(version);
    System.out.println(browserSize);
  }


  @Test
  void test6(){

    System.out.println("I want to say"+System.getProperty("anyText"));
  }
}
