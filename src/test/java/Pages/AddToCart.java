package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart {

    WebDriver driver = null;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement AddToCart_xpath;

    public AddToCart(WebDriver driver) {

        this.driver = driver;
    }

    public AddToCart clickAddToCartButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(AddToCart_xpath));

        AddToCart_xpath.click();
        return this;
    }

}
