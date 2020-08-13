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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Task9 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test1() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        int countrysize = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).size();
        for (int i = 0; i < countrysize - 1; i++) {
            String a1 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i).getAttribute("textContent");
            String a2 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i + 1).getAttribute("textContent");
            System.out.println(a1);
            System.out.println(a2);
            int result = a1.compareTo(a2);
            if (result < 0) {
                System.out.println("Страны отсортированы!" + i);
                System.out.println("---------------------");
            }


            if (!driver.findElements(By.xpath("//form[@name='countries_form']//td[6]")).get(i).getText().equals("0")) {
                driver.findElements(By.cssSelector("tr.row")).get(i).findElement(By.cssSelector("a")).click();
                int zonesize = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).size();
                for (int j = 0; j < zonesize - 1; j++) {
                    String zone1 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).get(j).getAttribute("innerText");
                    String zone2 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).get(j + 1).getAttribute("innerText");
                    int zresult = zone1.compareTo(zone2);
                    if (zresult < 0) {
                        System.out.println("Зоны отсортированы!" + j);
                    }
                }
                driver.findElement(By.xpath("//div[@id='box-apps-menu-wrapper']//li[3]/a")).click();
            }
        }
    }

    @After
    public void finish() {
        driver.quit();
    }
}
