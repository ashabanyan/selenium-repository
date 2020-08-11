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

public class Task8 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart");
        /*driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();*/
    }

    @Test
    public void test() {
        int ducks= driver.findElements(By.xpath("//li[@class='product column shadow hover-light']")).size();
        int stickers = driver.findElements(By.cssSelector("[class^=sticker")).size();
        Assert.assertEquals(ducks,stickers);
    }

    @After
    public void finish() {
        driver.quit();
    }
}

