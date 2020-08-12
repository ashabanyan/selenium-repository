import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Task9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void test1() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        int size = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).size();

        for (int i=0; i<size-1; i++) {
            String a1 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i).getAttribute("innerText");
            String a2 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i+1).getAttribute("innerText");
            int result = a1.compareTo(a2);
            boolean res;
            if (result < 0) {
                res = true;
            }
            else {res =  false;}

            Assert.assertTrue(res);
        }
    }

    

    @After
    public void finish() {
        driver.quit();
    }
}
