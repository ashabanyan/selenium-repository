import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
    private WebDriver driver;
    private WebDriverWait wait;

//    public boolean isElementPresent(By by) {
//        if (driver.findElement() > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

        @Test
    public void test() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost/litecart");

        int product_size = driver.findElements(By.cssSelector("[class^=product]")).size();
        for (int i = 0; i<product_size; i++) {
            if (driver.findElements(By.cssSelector("[class^=product]")).get(i).findElements(By.cssSelector("span")).size() > 0) {
                System.out.println("Элемент существует!");
            }
            else {
                System.out.println("Элемент не существует");
            }
        }

            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            driver.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);
        }

//    @After
//    public void finish() {
//        driver.quit();
//    }
}
