import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task11 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test1() {
        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("[name=login_form] [href]")).click();

        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Александр");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Шабанян");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("г.Москва, улица Мира, дом 128, кв. 314");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Los-Angeles");


        Select country = new Select(driver.findElement(By.name("country_code")));
        country.selectByVisibleText("United States");

//        String email = "test2@gmail.com";
//        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
//        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("89033583958");
//        String password = "123123123";
//        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
//        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);
//        driver.findElement(By.cssSelector("[name=create_account]")).click();
//
//        driver.findElement(By.xpath("//ul[@class='list-vertical']//li[5]/a")).click();
//
//        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
//        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
//        driver.findElement(By.cssSelector("[name=login]")).click();
//
//        driver.findElement(By.xpath("//ul[@class='list-vertical']//li[5]/a")).click();

    }

}
