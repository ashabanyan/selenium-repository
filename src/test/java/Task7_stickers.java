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

public class Task7_stickers {
    private WebDriver driver;
    private WebDriverWait wait;

    private boolean isElementPresent(String css) {
        try {
            driver.findElement(By.cssSelector(css));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    @Test
    public void test() {
        int size = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        for (int i = 0; i<size; i++) {
            driver.findElements(By.cssSelector("[class^=sticker"));
        }
    }


}

