import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test12 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String path = getClass().getClassLoader().getResource(".").getPath();
    private String Imagepath = "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\resources\\testduck.jpeg";


//    public void setDatepicker(String cssSelector, String date) {
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(cssSelector))));
//        JavascriptExecutor.class.cast(driver).executeScript(
//                String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
//    }

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
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        //driver.findElement(By.xpath("//li[@id='app-'][2]/a")).click();
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();

        driver.findElement(By.xpath("//div[@id='tab-general']//tr[1]//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("Test duck");
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("TEST01");
        driver.findElement(By.xpath("//td[contains(text(), 'Male')]/..//input")).click();

        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");

        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(Imagepath);


        driver.findElement(By.name("date_valid_from")).sendKeys("01012020");
        driver.findElement(By.name("date_valid_to")).sendKeys("31122020");



        Select country = new Select(driver.findElement(By.cssSelector("select[name='country_code']")));
        country.selectByVisibleText("United States");




        driver.findElement(By.cssSelector("button[name=save]")).click();



    }


}
