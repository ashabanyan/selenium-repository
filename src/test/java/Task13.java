import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class Task13 {
    private WebDriver driver;
    private WebDriverWait wait;


    public void isSelectSize() {
        if (driver.findElements(By.xpath("//strong[contains(text(),'Size')]")).size() != 0) {
            Select country = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
            country.selectByVisibleText("Small");
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        }
        else {
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
        }
    }

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(0).click();
        isSelectSize();
        WebElement quantity = driver.findElement(By.cssSelector("span[class='quantity']"));
        wait.until(textToBePresentInElement(quantity, "1"));

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(0).click();
        isSelectSize();
        WebElement quantity2 = driver.findElement(By.cssSelector("span[class='quantity']"));
        wait.until(textToBePresentInElement(quantity2, "2"));

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).get(0).click();
        isSelectSize();
        WebElement quantity3 = driver.findElement(By.cssSelector("span[class='quantity']"));
        wait.until(textToBePresentInElement(quantity3, "3"));



        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

        driver.findElements(By.xpath("//div[@class='viewport']//button[contains(text(),'Remove')]")).get(1).click();

//        wait.until((driver.findElements(By.xpath("//td[@class='item']")).size() == 2));
////        int count = driver.findElements(By.xpath("//td[@class='item']")).size();
////        Assert.assertEquals(count, Integer.parseInt("2"));



    }



}
