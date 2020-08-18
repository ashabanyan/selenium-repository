import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Test12 {
    private WebDriver driver;
    private WebDriverWait wait;
    Random random = new Random();
    File file = new File("resources/testduck.jpeg");
    String Imagepath = file.getAbsolutePath();

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='tab-general']//tr[1]//input[@value='1']")).click();

        String name = "Duck" + random.nextInt();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys(name);
        String code = "TD" + random.nextInt();
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys(code);
        driver.findElement(By.xpath("//td[contains(text(), 'Male')]/..//input")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(Imagepath);
        driver.findElement(By.name("date_valid_from")).sendKeys("01012020");
        driver.findElement(By.name("date_valid_to")).sendKeys("31122020");
        driver.findElement(By.xpath(".//a[contains(text(),\"Information\")]")).click();

        Select country = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        country.selectByVisibleText("ACME Corp.");

        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("Short description of test duck");
        driver.findElement(By.cssSelector("[class=trumbowyg-editor]")).sendKeys("Test");
        driver.findElement(By.xpath(".//a[contains(text(),\"Prices\")]")).click();
        driver.findElement(By.cssSelector("[name=purchase_price]")).clear();
        driver.findElement(By.cssSelector("[name=purchase_price]")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name='prices[USD]']")).sendKeys("100");
        driver.findElement(By.cssSelector("button[name=save]")).click();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        String savedname = driver.findElement(By.xpath(".//a[contains(text()," + "\"" + name + "\"" + ")]")).getText();
        if (savedname.equals(name)) {
            System.out.println("Товар добавлен!");
        }
        else {
            System.out.println("Товара нет в списке!");
        }
    }

    @After
    public void finish() {
        driver.quit();
    }
}
