import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class TaskMainPage extends Task19 {

    public Task19 task19;
    private WebDriver driver;
    private WebDriverWait wait;

    private TaskProductPage taskProductPage;

    public TaskMainPage(WebDriver driver) { this.driver = driver;}

    public void mainPage() {
        TaskProductPage taskProductPage = new TaskProductPage(driver);
        for (int i = 0; i<3; i++) {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(0).click();

            WebElement counts = driver.findElement(By.xpath("//span[@class='quantity']"));
            int count1 = Integer.parseInt(counts.getText());
            taskProductPage.selectSize();
//            if (driver.findElements(By.xpath("//strong[contains(text(),'Size')]")).size() != 0) {
//                Select country = new Select(this.driver.findElement(By.cssSelector("select[name='options[Size]']")));
//                country.selectByVisibleText("Small");
//                driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
//            } else {
//                driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
//            }

            wait.until(textToBePresentInElement(counts, String.valueOf(count1+1)));

            driver.get("https://litecart.stqa.ru/en/");



        }
    }

}
