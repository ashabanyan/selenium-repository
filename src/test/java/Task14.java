import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class Task14 {
    private WebDriver driver;
    private WebDriverWait wait;

    public ExpectedCondition<String> anyWindowOtherThan(final String window) {
        return new ExpectedCondition<String>() {
            @NullableDecl
            public String apply(@NullableDecl WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.remove(window);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']")).click();
        String oldWindows = driver.getWindowHandle();


        int size = driver.findElements(By.xpath("//a[@target='_blank']/i[@class='fa fa-external-link']")).size();
        for (int i = 0; i<size; i++) {
            driver.findElements(By.xpath("//a[@target='_blank']/i[@class='fa fa-external-link']")).get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));

            Set<String> newWindows = driver.getWindowHandles();
            Iterator<String> element = newWindows.iterator();
            while(element.hasNext()){
                if (element.next()!=oldWindows) {
                    driver.switchTo().window(element.next());
                    driver.close();
                    driver.switchTo().window(oldWindows);
                }
            }
        }
    }
}