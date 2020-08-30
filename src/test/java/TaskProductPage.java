import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskProductPage extends Task19 {

    public Task19 task19;
    private WebDriver driver;
    private WebDriverWait wait;

    public TaskProductPage(WebDriver driver) { this.driver = driver;}

    public void selectSize() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        if (driver.findElements(By.xpath("//strong[contains(text(),'Size')]")).size() != 0) {
            Select country = new Select(this.driver.findElement(By.cssSelector("select[name='options[Size]']")));
            country.selectByVisibleText("Small");
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        } else {
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        }
    }
}
