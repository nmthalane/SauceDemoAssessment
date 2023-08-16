package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourCart {

    WebDriver driver = null;

    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(.,'Sauce Labs Backpack')]")
    WebElement yourCart_xpath;

    @FindBy(id = "checkout")
    WebElement checkout_id;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack_id;

    @FindBy(xpath = "//a[contains(@class,'link')]")
    WebElement itemRemoved_xpath;
    @FindBy(id = "continue-shopping")
    WebElement continueShopping_id;

    public YourCart(WebDriver driver) {
        this.driver = driver;
    }

    public YourCart verify_ItemAdded_to_Cart() {

        String itemVisibleInCart = yourCart_xpath.getText();

        Assert.assertEquals(itemVisibleInCart, "Sauce Labs Backpack");

        return this;
    }

    public YourCart clickCheckoutButton() {
        checkout_id.click();
        return this;
    }

    public YourCart clickRemoveButton() {

        removeBackpack_id.click();
        return this;
    }

    public YourCart click_ContinueShopping_Button() {
        continueShopping_id.click();
        return this;
    }

    public YourCart verify_Item_Removed_From_Cart() {

        String ItemAddedToCart = itemRemoved_xpath.getText();
        Assert.assertEquals(ItemAddedToCart, "");

        return this;
    }

//    public YourCart GetSize() {
//
//        String ItemAddedToCart = itemRemoved_xpath.getText();
//        if (ItemAddedToCart.isEmpty()) {
//            Assert.assertTrue(true);
//            System.out.println("Before");
//        } else {
//            Assert.fail();
//            System.out.println("After");
//        }
//
//
//        return this;
//    }

}
