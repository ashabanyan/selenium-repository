import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;

public class Task10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = BrowserProperties.getProperty("chrome");
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart");




        int campaigns_size = driver.findElements(By.cssSelector("[id=box-campaigns]")).size();
        for (int i =0; i<campaigns_size; i++) {
            //-----------------------------------Запись переменных на главной странице---------------------
            String outname = driver.findElements(By.cssSelector("[id=box-campaigns] [class=name]")).get(i).getText();
            String outregprice = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']")).get(i).findElement(By.cssSelector("[class=regular-price]")).getText();
            String outsaleprice = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//div[@class='price-wrapper']")).get(i).findElement(By.cssSelector("[class=campaign-price]")).getText();
            String outregcolor = driver.findElement(By.cssSelector("[id=box-campaigns] [class=regular-price]")).getCssValue("color");
            String[] coloroutreg = outregcolor.split(",");
            String outregthrough = driver.findElement(By.cssSelector("[id=box-campaigns] [class=regular-price]")).getCssValue("text-decoration-line");
            String outsalecolor = driver.findElement(By.cssSelector("[id=box-campaigns] [class=campaign-price]")).getCssValue("color");
            String[] coloroutsale = outsalecolor.split(",");
            String outsalestrong = driver.findElements(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']//strong")).get(i).getAttribute("class");
            String outregsize = driver.findElement(By.cssSelector("[id=box-campaigns] [class=regular-price]")).getCssValue("font-size");
            String outsalesize = driver.findElement(By.cssSelector("[id=box-campaigns] [class=campaign-price]")).getCssValue("font-size");

            //-----------------------------------Переход на страницу карточки------------------------------
            driver.findElements(By.cssSelector("[id=box-campaigns] [class=link]")).get(i).click();

            //-----------------------------------Запись переменных на в карточке товара--------------------
            String inname = driver.findElement(By.cssSelector("h1")).getText();
            String inregprice = driver.findElement(By.cssSelector("[class=content] [class=price-wrapper] [class=regular-price]")).getText();
            String insaleprice = driver.findElement(By.cssSelector("[class=content] [class=price-wrapper] [class=campaign-price]")).getText();
            String inregcolor = driver.findElement(By.cssSelector("[class=content] [class=regular-price]")).getCssValue("color");
            String[] colorinreg = inregcolor.split(",");
            String inregthrough = driver.findElement(By.cssSelector("[class=content] [class=regular-price]")).getCssValue("text-decoration-line");
            String insalecolor = driver.findElement(By.cssSelector("[class=content] [class=campaign-price]")).getCssValue("color");
            String[] colorinsale = insalecolor.split(",");
            String insalestrong = driver.findElements(By.xpath("//div[@class='content']//div[@class='information']//div[@class='price-wrapper']/strong")).get(i).getAttribute("class");
            String inregsize = driver.findElement(By.cssSelector("[class=content] [class=regular-price]")).getCssValue("font-size");
            String insalesize = driver.findElement(By.cssSelector("[class=content] [class=campaign-price]")).getCssValue("font-size");

            //----------------------------------------Проверки---------------------------------------------
            if (outname.equals(inname)) {
                System.out.println("Названия совпадают: " + outname + " & " + inname);
            }
            System.out.println("--------------------------------------------");
            if (outregprice.equals(inregprice)) {
                System.out.println("Регулярные цены совпадают: " + outregprice + " & " + inregprice);
            }
            System.out.println("--------------------------------------------");
            if (outsaleprice.equals(insaleprice)) {
                System.out.println("Акционные цены совпадают: " + outsaleprice + " & " + insaleprice);
            }
            System.out.println("--------------------------------------------");
            if ((coloroutreg[0].substring(5).equals(coloroutreg[1].substring(1))) && (coloroutreg[1].substring(1).equals(coloroutreg[2].substring(1))) & outregthrough.equals("line-through")) {
                System.out.println("Регулярная цена на главной странице отображена в сером цвете и перечеркнута");
            }
            System.out.println("--------------------------------------------");
            if ((coloroutsale[1].substring(1).equals("0")) && (coloroutsale[2].substring(1).equals("0")) & outsalestrong.equals("campaign-price")) {
                System.out.println("Акционная цена на главной странице отображена в красном цвете и в жирном шрифте!");
            }
            System.out.println("--------------------------------------------");
            if ((colorinreg[0].substring(5).equals(colorinreg[1].substring(1))) && (colorinreg[1].substring(1).equals(colorinreg[2].substring(1))) & inregthrough.equals("line-through")) {
                System.out.println("Регулярная цена в карточке товара отображена в сером цвете и перечеркнута");
            }
            System.out.println("--------------------------------------------");
            if ((colorinsale[1].substring(1).equals("0")) && (colorinsale[2].substring(1).equals("0")) & insalestrong.equals("campaign-price")) {
                System.out.println("Акционная цена в карточке товара отображена в красном цвете и в жирном шрифте!");
            }
            System.out.println("--------------------------------------------");
            if (outsalesize.compareTo(outregsize) > 0) {
                System.out.println("Акционная цена крупнее регулярной на главной странице!");
            }
            System.out.println("--------------------------------------------");
            if (insalesize.compareTo(inregsize) > 0) {
                System.out.println("Акционная цена крупнее регулярной в карточке товара!");
            }
        }
    }



    @After
    public void finish() {
        driver.quit();
    }
}
