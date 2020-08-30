import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;

public class TaskCheckoutPage {

    public Task19 task19;
    private WebDriver driver;
    private WebDriverWait wait;


    public TaskCheckoutPage(WebDriver driver) { this.driver = driver;}

    public void deleteProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
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
}
