import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Task7_new {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    @Test
    public void test() {
        int par = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i = 0; i<par; i++) {
            driver.findElements(By.cssSelector("li#app-")).get(i).click();
            for (int j = 0; j<driver.findElements(By.cssSelector("[id^=doc-")).size(); j++) {
                driver.findElements(By.cssSelector("[id^=doc-")).get(j).click();
                driver.findElement(By.cssSelector("h1"));
                System.out.println(driver.findElement(By.cssSelector("h1")).getText());
            }
        }
    }

    @After
    public void finish() {
        driver.quit();
    }



}