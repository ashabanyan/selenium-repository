import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Task15 {

    @Test
    public void test() {

        try{
           WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.73:4444/wd/hub"), new ChromeOptions());
           driver.get("https://www.selenium.dev/");
       }
       catch( MalformedURLException ex) {
           System.out.println("Ошибка!");
       }
   }
}
