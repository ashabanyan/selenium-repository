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
    public void test1_a() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        int name_size = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).size();

        for (int i=0; i<name_size-1; i++) {
            String a1 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i).getAttribute("innerText");
            String a2 = driver.findElements(By.xpath("//form[@name='countries_form']//td[5]")).get(i+1).getAttribute("innerText");
            int result = a1.compareTo(a2);
            boolean res;
            if (result < 0) {
                res = true;
            }
            else {res =  false;}

            Assert.assertTrue(res);
        }
    }

    @Test
    public void test1_b() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

        ArrayList<String> list = new ArrayList<String>();

        int zones_size = driver.findElements(By.xpath("//form[@name='countries_form']//td[6]")).size();
        for (int i = 0; i < zones_size - 1; i++) {
            String a = driver.findElements(By.xpath("//form[@name='countries_form']//td[6]")).get(i).getAttribute("textContent");
            if (parseInt(a) != 0) {
                list.add(driver.findElements(By.xpath("//form[@name='countries_form']//td[5]/a")).get(i).getAttribute("href"));
            } else {}
        }

        for (int j = 0; j < list.size(); j++) {
            driver.get(list.get(j));
            int inname_size = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).size();

            for (int k = 0; k < inname_size - 1; k++) {
                String a1 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).get(k).getAttribute("innerText");
                String a2 = driver.findElements(By.xpath("//table[@class='dataTable']//td[3]")).get(k+1).getAttribute("innerText");
                int result = a1.compareTo(a2);
                boolean res;
                if (result < 0) {
                    res = true;
                } else res = false;

                Assert.assertTrue(res);
            }

        }
    }

    @After
    public void finish() {
        driver.quit();
    }
}
