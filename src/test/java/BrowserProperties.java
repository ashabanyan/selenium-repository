import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class BrowserProperties {

    public static WebDriver getProperty(String browser) {
        if (browser=="chrome") {
            System.setProperty("webdriver.chrome.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }

        else if (browser == "firefox") {
            System.setProperty("webdriver.gecko.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }

        else if (browser == "explorer") {
            System.setProperty("webdriver.ie.driver", "D:\\Education\\Testing\\Selenium WebDriver\\selenium-repository\\drivers\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        }

        else {return null;}
    }
}
