package TestStepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class StepDefinition extends Basepage {
    public StepDefinition() throws InterruptedException {
    }

    // WebDriver driver;
  //  LoginsPages loginsPages = new LoginsPages(driver);
    @Given("I am on Login page")
    public void i_am_on_login_page() {
        loginsPages.loginInput();

    }

    @And("^I enter the username (.*)$")
    public void i_enter_the_username_user_name(String username) {
        loginsPages.enter_email(username);
    }

    @And("^I enter password (.*)$")
    public void i_enter_password_pass(String password) {
        loginsPages.enter_password(password);
    }

    @When("I click login button")
    public void i_click_login_button() {
        loginsPages.loginButton();
    }

  @Then("The home page is displayed")
   public void the_home_page_is_displayed() {

   }

    @Given("I on the Home page")
    public void i_on_the_home_page() {

    }
    @Given("I select the Computers tab")
    public void i_select_the_computers_tab() {

        addToCart.selectComputer();
    }
    @Given("I select desktops to purchase")
    public void i_select_desktops_to_purchase() {
        addToCart.selectDesktop();
    }
    @When("I click on item to add to cart")
    public void i_click_on_item_to_add_to_cart() {
        addToCart.addToCart();
    }
    @Then("Cart Page is opened")
    public void cart_page_is_opened() {
        addToCart.verifyItemInCart();
    }

    @Test
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/jpg","imageFailed");
        }
    }

    @After
    public void closeBrowser(){
        driver.quit();

    }

}
