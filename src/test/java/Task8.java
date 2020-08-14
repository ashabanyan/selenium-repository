import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
    }

    @Test
    public void test1() {
        int ducks= driver.findElements(By.cssSelector("[class^=product]")).size();
        for (int i = 0; i< ducks; i++) {
            int count = driver.findElements(By.cssSelector("[class^=product]")).get(i).findElements(By.cssSelector("div[class^=sticker]")).size();
            boolean result;
            if (count == 1) {
                result = true;
                System.out.println("У товара под номером №" + (i+1) + " - " + count + " стикер/ов!");
            } else {result=false;}
            Assert.assertTrue(result);
        }
    }

    @After
    public void finish() {
        driver.quit();
    }
}

