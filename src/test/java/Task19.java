import javafx.concurrent.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task19 {
    private WebDriver driver;
    private WebDriverWait wait;

    private TaskMainPage taskMainPage;
    private TaskCheckoutPage taskCheckoutPage;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("chrome");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        TaskMainPage taskMainPage = new TaskMainPage(driver);
        TaskCheckoutPage taskCheckoutPage = new TaskCheckoutPage(driver);
        driver.get("https://litecart.stqa.ru/en/");

        taskMainPage.mainPage();

        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
        wait.until(visibilityOfElementLocated(By.name("remove_cart_item")));

        taskCheckoutPage.deleteProduct();

    }

    @After
    public void finish() {
        driver.quit();
    }
}
