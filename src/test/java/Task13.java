
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task13 {
    private WebDriver driver;
    private WebDriverWait wait;


    public void isSelectSize() {
        if (driver.findElements(By.xpath("//strong[contains(text(),'Size')]")).size() != 0) {
            Select country = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
            country.selectByVisibleText("Small");
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        } else {
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        }
    }

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("chrome");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        for (int i = 0; i<3; i++) {
            driver.get("https://litecart.stqa.ru/en/");
            driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(0).click();
            isSelectSize();
            WebElement quantity = driver.findElement(By.cssSelector("span[class='quantity']"));
            String expquan = Integer.toString(i+1);
            System.out.println("quantity = " + quantity.getText());
            wait.until(textToBePresentInElement(quantity, expquan));
        }

        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

        wait.until(visibilityOfElementLocated(By.name("remove_cart_item")));
        int countRow = 1;
        while (countRow > 0) {
            countRow = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']/tbody/tr/td[@class='item']")).size();
            WebElement del = wait.until(elementToBeClickable(By.name("remove_cart_item")));
            try {
                del.click();
            } catch (TimeoutException ignore) {
            }
            System.out.println(countRow);
            try {
                wait.until(numberOfElementsToBeLessThan(By.xpath("//table[@class='dataTable rounded-corners']/tbody/tr/td[@class='item']"), countRow));
                countRow = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']/tbody/tr/td[@class='item']")).size();
                System.out.println(countRow);
            } catch (TimeoutException ignore) {
            }
        }
    }

    @After
    public void finish() {
        driver.quit();
    }
}

