package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.Duration;

public class CheckoutOverview {

    WebDriver driver = null;

    @FindBy(xpath = "//span[@class='title'][contains(.,'Checkout: Overview')]")
    WebElement checkoutOverView_xpath;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement backPack_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    WebElement subtotal_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_tax_label')]")
    WebElement taxLabel_xpath;

    @FindBy(xpath = "//div[contains(@class,'summary_info_label summary_total_label')]")
    WebElement total_xpath;

    @FindBy(id = "finish")
    WebElement finishButton_id;

    @FindBy(xpath = "//h2[@class='complete-header'][contains(.,'Thank you for your order!')]")
    WebElement orderCompleteMessage_xpath;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuButton_id;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton_id;

    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutOverview verify_CheckoutOverview_Screen_isVisible() {

        String checkoutOverview = checkoutOverView_xpath.getText();
        Assert.assertEquals(checkoutOverview, "Checkout: Overview");
        return this;
    }

    public CheckoutOverview verify_Item_isVisible() {
        String itemIsVisible = backPack_xpath.getText();
        Assert.assertEquals(itemIsVisible, "Sauce Labs Backpack");
        return this;
    }

    public CheckoutOverview Verify_itemTotal_Plus_tax_isEqual_to_Total() {
        String itemTotalLabel = subtotal_xpath.getText().replace("Item total: $", "");
        String taxLabel = taxLabel_xpath.getText().replace("Tax: $", "");
        String total_Label = total_xpath.getText().replace("Total: $", "");

        double itemTotal = Double.parseDouble(itemTotalLabel);
        ;
        double total = Double.parseDouble(total_Label);
        ;
        double tax_rate = 0.08;

        double total_plus_tax = itemTotal * tax_rate + itemTotal;
        // Create a DecimalFormat object with the desired format
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        // Set the rounding mode (optional)value will be rounded to the nearest even number 3.56
        decimalFormat.setRoundingMode(java.math.RoundingMode.HALF_UP);
        // Format the number to the specified decimal places
        double final_total_plus_tax = Double.parseDouble(decimalFormat.format(total_plus_tax));

        if (final_total_plus_tax == total) {
            finishButton_id.click();
            String orderConfirmationMessage = orderCompleteMessage_xpath.getText();
            Assert.assertEquals(orderConfirmationMessage, "Thank you for your order!");
        } else {
            assert false;
        }

        burgerMenuButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton_id));
        logoutButton_id.click();

        return this;
    }

}
