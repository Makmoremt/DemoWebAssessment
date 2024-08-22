package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
//import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;

    @BeforeClass
    public static WebDriver startBrowser(String browserChoice, String url) throws InterruptedException {
        if ("chrome".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browserChoice)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(15);
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }


}
