package Pages;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginsPages {
    public WebDriver driver;
    @FindBy(xpath = "//a[contains(@class,'ico-login')]")
    WebElement login_link;

    @FindBy(xpath = "//strong[contains(.,'Returning Customer')]")
    WebElement enter_inputs;
    @FindBy(xpath = "//input[contains(@id,'Email')]")
    WebElement email_txt;

    @FindBy(xpath = "//a[contains(.,'Register')]")
    WebElement register;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password_txt;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement login_button;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    WebElement submit_button;
    public LoginsPages(WebDriver driver){this.driver = driver;}

    public void loginInput()
    {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(register));
        login_link.click();
    }
    public void enter_email(String email_input){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(enter_inputs));
        email_txt.sendKeys(email_input);
    }
    public void enter_password(String password_input){password_txt.sendKeys(password_input);}
    public void loginButton()
    {
        submit_button.submit();
    }
}
