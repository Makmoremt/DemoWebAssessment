package TestStepDefinition;

import Pages.AddToCart;
import Pages.LoginsPages;
import Util.BrowserFactory;
import Util.TakeScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("chrome","https://demowebshop.tricentis.com/login");


     AddToCart addToCart = PageFactory.initElements(driver,AddToCart.class);
     LoginsPages loginsPages = PageFactory.initElements(driver,LoginsPages.class);

    TakeScreenShots takeScreenShots = new TakeScreenShots();

    public Basepage() throws InterruptedException {
    }

}
