package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {

    WebDriver driver = null;

    @FindBy(xpath = "//span[contains(.,'Products')]")
    WebElement products_xpath;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBackpack_id;

    @FindBy(xpath = "//span[@class='shopping_cart_badge'][contains(.,'1')]")
    WebElement itemAdded_xpath;

    @FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
    WebElement shoppingCartBadge_xpath;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public HomePage verifySuccessful() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(products_xpath));

        String loginSuccessful = products_xpath.getText();

        Assert.assertEquals(loginSuccessful, "Products");

        return this;
    }

    public HomePage verify_Item_Added_To_Cart() {

        String ItemAddedToCart = itemAdded_xpath.getText();
        Assert.assertEquals(ItemAddedToCart, "1");

        return this;
    }

    public void clickShoppingCartBadge() {
        shoppingCartBadge_xpath.click();
    }

}
