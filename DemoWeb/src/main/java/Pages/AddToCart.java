package Pages;

import io.cucumber.java.After;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCart {
    public WebDriver driver;
    @FindBy(xpath = "(//a[contains(.,'Computers')])[1]")
    WebElement computers;
    @FindBy(xpath = "(//a[contains(.,'Computers')])[1]")
    WebElement computer_list;

    @FindBy(xpath = "//h2[contains(.,'Desktops')]")
    WebElement desktop_list;

    @FindBy(xpath = "//h1[contains(.,'Desktops')]")
    WebElement desktops_page;

    @FindBy(xpath = "(//input[contains(@value,'Add to cart')])[2]")
    WebElement cart_input;

    @FindBy(xpath = "//h1[contains(.,'Build your own computer')]")
    WebElement build_comp;

    @FindBy(xpath = "//span[contains(.,'Shopping cart')]")
    WebElement shopping_cart_link;

    @FindBy(xpath = "//h1[contains(.,'Shopping cart')]")
    WebElement shop_cart_page;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    public void selectComputer() {
        computers.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(computer_list));
    }

    public void selectDesktop() {
        desktop_list.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(desktops_page));
    }

    public void addToCart() {
        cart_input.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(build_comp));

        String item_build = build_comp.getText();
        Assert.assertEquals("Build your own computer", item_build);
    }

    public void verifyItemInCart() {
        shopping_cart_link.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(shop_cart_page));

        String item_build = shop_cart_page.getText();
        Assert.assertEquals("Shopping cart", item_build);
    }
}

