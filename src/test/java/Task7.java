import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class Task7 {
    private WebDriver driver;
    private WebDriverWait wait;


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
    public void test1() {
        driver.findElement(By.xpath(".//ul[@id='box-apps-menu']/li[1]/a")).click();
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath(".//li[@id='doc-template']/a")).click();
        WebElement element = wait.until(presenceOfElementLocated(By.xpath("//h1")));
        Assert.assertNotNull(driver.findElement(By.xpath("//h1")).getText());
    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[1]/a")).click();
        wait = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath(".//li[@id='doc-logotype']/a")).click();
        WebElement element = wait.until(presenceOfElementLocated(By.xpath("//h1")));
        Assert.assertNotNull(driver.findElement(By.xpath("//h1")).getText());
    }

    @After
    public void finish() {
        driver.quit();
    }





}
