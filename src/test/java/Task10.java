import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart");

        int campaigns_size = driver.findElements(By.cssSelector("[id=box-campaigns]")).size();
        for (int i =0; i<campaigns_size; i++) {
            String outname = driver.findElements(By.cssSelector("[id=box-campaigns] [class=name]")).get(i).getText();
            String outregprice = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']")).get(i).findElement(By.cssSelector("[class=regular-price]")).getText();
            String outsaleprice = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']")).get(i).findElement(By.cssSelector("[class=campaign-price]")).getText();

            String regcolor = driver.findElement(By.cssSelector("[id=box-campaigns] [class=regular-price]")).getCssValue("color");
            String through = driver.findElement(By.cssSelector("[id=box-campaigns] [class=regular-price]")).getCssValue("text-decoration-line");

            String salecolor = driver.findElement(By.cssSelector("[id=box-campaigns] [class=campaign-price]")).getCssValue("color");
            System.out.println(salecolor);

            String salebold = driver.findElement(By.cssSelector("[id=box-campaigns] [class=campaign-price]")).getCssValue("font-weight");
            System.out.println(salebold);




            driver.findElements(By.cssSelector("[id=box-campaigns] [class=link]")).get(i).click();
            System.out.println("----------------------------------------");




            String inname = driver.findElement(By.cssSelector("h1")).getText();
            String inregprice = driver.findElement(By.cssSelector("[class=content] [class=price-wrapper] [class=regular-price]")).getText();
            String insaleprice = driver.findElement(By.cssSelector("[class=content] [class=price-wrapper] [class=campaign-price]")).getText();
            if (outname.equals(inname)) {
                System.out.println(outname + " & " + inname + " - названия совпадают!");
            }

            if (outregprice.equals(inregprice)) {
                System.out.println("Регулярные цены совпадают: " + outregprice + " & " + inregprice);
            }

            if (outsaleprice.equals(insaleprice)) {
                System.out.println("Акционные цены совпадают: " + outsaleprice + " & " + insaleprice);
            }

            if (regcolor.equals("rgb(119, 119, 119)") & through.equals("line-through")) {
                System.out.println("Регулярная цена отображена в сером цвете и перечеркнута");
            }

            //if (salecolor.equals("rgb(204, 0, 0)") & )

        }


    }

    @After
    public void finish() {
        driver.quit();
    }
}
