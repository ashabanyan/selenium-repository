import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test12 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String path = getClass().getClassLoader().getResource(".").getPath();
    private String Imagepath = "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\target\\test-classes\\testduck.jpeg";

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
        driver.findElement(By.xpath(".//span[contains(text(),\"Catalog\")]/..")).click();
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();

        driver.findElement(By.xpath("//div[@id='tab-general']//tr[1]//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("Test duck");
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("TEST01");
        driver.findElement(By.xpath("//td[contains(text(), 'Male')]/..//input")).click();

        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");

        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(Imagepath);



        System.out.println(path);
    }


}
