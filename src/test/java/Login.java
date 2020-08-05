import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
//          System.setProperty("webdriver.chrome.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\chromedriver.exe");
//          driver = new ChromeDriver();

//          System.setProperty("webdriver.gecko.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\geckodriver.exe");
//          driver = new FirefoxDriver();
//


            System.setProperty("webdriver.ie.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

            wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void login() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
