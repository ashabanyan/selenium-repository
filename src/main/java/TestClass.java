import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {

    public static void main(String[] args) {
        WebDriver driver;
        WebDriverWait wait;

        System.setProperty("webdriver.gecko.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        int size = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).size();

        for (int i=0; i<size-1; i++) {
            String a1 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i).getAttribute("innerText");
            String a2 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i+1).getAttribute("innerText");
            int result = a1.compareTo(a2);
            System.out.println(result);
        }

//        String c = driver.findElement(By.xpath("//form[@name='countries_form']//tr[2]/td[5]")).getAttribute("innerText");
//        System.out.println(size);


        {
            driver.quit();
        }


    }
}
