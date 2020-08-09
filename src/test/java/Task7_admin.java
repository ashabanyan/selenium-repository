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


public class Task7_admin {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = BrowserProperties.getProperty("firefox");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    }

    // --------------------------Appearence----------------------------
    String[] appearence_locator = {"//li[@id='doc-template']/a", "//li[@id='doc-logotype']/a" };
    @Test
    public void appearence() {
        driver.findElement(By.xpath("//li[1]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<2; i++) {
            driver.findElement(By.xpath(appearence_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------------Catalog-----------------------------
    String[] catalog_locator = {
            "//li[@id='doc-catalog']/a",
            "//li[@id='doc-product_groups']/a",
            "//li[@id='doc-option_groups']/a",
            "//li[@id='doc-manufacturers']/a",
            "//li[@id='doc-suppliers']/a",
            "//li[@id='doc-delivery_statuses']/a",
            "//li[@id='doc-sold_out_statuses']/a",
            "//li[@id='doc-quantity_units']/a",
            "//li[@id='doc-csv']/a"
    };
    
    @Test
    public void catalog() {
        driver.findElement(By.xpath("//li[2]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<9; i++) {
            driver.findElement(By.xpath(catalog_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------------Countries----------------------------
    @Test
    public void countries() {
        driver.findElement(By.xpath("//li[3]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //-----------------------------Currencies----------------------------
    @Test
    public void currencies() {
        driver.findElement(By.xpath("//li[4]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //-----------------------------Customers------------------------------
    String[] customers_locator = {
            "//li[@id='doc-customers']/a",
            "//li[@id='doc-csv']/a",
            "//li[@id='doc-newsletter']/a",
    };

    @Test
    public void customers() {
        driver.findElement(By.xpath("//li[5]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<3; i++) {
            driver.findElement(By.xpath(customers_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------------Geo Zones---------------------------
    @Test
    public void geozones() {
        driver.findElement(By.xpath("//li[6]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //-----------------------------Languages---------------------------
    String[] language_locator = {"//li[@id='doc-languages']/a", "//li[@id='doc-storage_encoding']/a" };
    @Test
    public void languages() {
        driver.findElement(By.xpath("//li[7]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<2; i++) {
            driver.findElement(By.xpath(language_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------------Modules------------------------------
    String[] modules_locator = {
            "//li[@id='doc-jobs']/a",
            "//li[@id='doc-customer']/a",
            "//li[@id='doc-shipping']/a",
            "//li[@id='doc-payment']/a",
            "//li[@id='doc-order_total']/a",
            "//li[@id='doc-order_success']/a",
            "//li[@id='doc-order_action']/a",};

    @Test
    public void modules() {
        driver.findElement(By.xpath("//li[8]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<7; i++) {
            driver.findElement(By.xpath(modules_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-------------------------Orders------------------------
    String[] orders_locator = {"//li[@id='doc-orders']/a", "//li[@id='doc-order_statuses']/a" };
    @Test
    public void orders() {
        driver.findElement(By.xpath("//li[9]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<2; i++) {
            driver.findElement(By.xpath(orders_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-------------------------Pages-------------------------
    @Test
    public void pages() {
        driver.findElement(By.xpath("//li[10]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //-------------------------Reports-----------------------
    String[] reports_locator = {"//li[@id='doc-monthly_sales']/a", "//li[@id='doc-most_sold_products']/a", "//li[@id='doc-most_shopping_customers']/a" };
    @Test
    public void reports() {
        driver.findElement(By.xpath("//li[11]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<3; i++) {
            driver.findElement(By.xpath(reports_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-------------------------Settings----------------------
    String[] settings_locator = {
            "//li[@id='doc-store_info']/a",
            "//li[@id='doc-defaults']/a",
            "//li[@id='doc-general']/a",
            "//li[@id='doc-listings']/a",
            "//li[@id='doc-images']/a",
            "//li[@id='doc-checkout']/a",
            "//li[@id='doc-advanced']/a",
            "//li[@id='doc-security']/a"};

    @Test
    public void settings() {
        driver.findElement(By.xpath("//li[12]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<8; i++) {
            driver.findElement(By.xpath(settings_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //------------------------Slides------------------------
    @Test
    public void slides() {
        driver.findElement(By.xpath("//li[13]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //------------------------Tax---------------------------
    String[] tax_locator = {"//li[@id='doc-tax_classes']/a", "//li[@id='doc-tax_rates']/a" };
    @Test
    public void tax() {
        driver.findElement(By.xpath("//li[14]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<2; i++) {
            driver.findElement(By.xpath(tax_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------Translations--------------------
    String[] translations_locator = {"//li[@id='doc-search']/a", "//li[@id='doc-scan']/a", "//li[@id='doc-csv']/a" };
    @Test
    public void translations() {
        driver.findElement(By.xpath("//li[15]/a")).click();
        wait = new WebDriverWait(driver, 5);
        for (int i = 0; i<3; i++) {
            driver.findElement(By.xpath(translations_locator[i])).click();
            WebElement element = wait.until(presenceOfElementLocated(By.tagName("h1")));
            Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.findElement(By.tagName("h1")).getText());
        }
    }

    //-----------------------Users---------------------------
    @Test
    public void users() {
        driver.findElement(By.xpath("//li[16]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }

    //-----------------------vQmods--------------------------
    @Test
    public void vqmods() {
        driver.findElement(By.xpath("//li[17]/a")).click();
        wait = new WebDriverWait(driver, 5);
        Assert.assertNotNull(driver.findElement(By.tagName("h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }


    @After
    public void finish() {
        driver.quit();
    }





}
