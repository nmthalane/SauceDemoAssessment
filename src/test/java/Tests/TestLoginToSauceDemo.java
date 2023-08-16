package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestLoginToSauceDemo extends BaseTests {

    @Test
    public void verify_Error_Message_isReturned_When_Login_isUnsuccessful() {
        takeScreenshots
                .takeSnapshot(driver,"Login Screen");
        loginPage
                .enterUsername(readFromExcel.username)
                .enterPassword(readFromExcel.password + " ")
                .clickLoginButton()
                .verifyUnsuccessfulLogin();

        takeScreenshots
                .takeSnapshot(driver,"Login Error");
    }

    @Test(dependsOnMethods = "verify_Error_Message_isReturned_When_Login_isUnsuccessful")
    public void verify_Login_is_Successful() {
        loginPage
                .enterUsername(readFromExcel.username)
                .enterPassword(readFromExcel.password)
                .clickLoginButton();
        homePage
                .verifySuccessful();

        takeScreenshots
                .takeSnapshot(driver,"Home Page");
    }

    @Test(dependsOnMethods = "verify_Login_is_Successful")
    public void clickAddToCart() {

        addToCart
                .clickAddToCartButton();

        takeScreenshots
                .takeSnapshot(driver,"Add to Cart");
    }

    @Test(dependsOnMethods = "clickAddToCart")
    public void verify_Item_Added_To_Cart() {

        homePage
                .verify_Item_Added_To_Cart();
    }

    @Test(dependsOnMethods = "verify_Item_Added_To_Cart")
    public void clickShoppingCart() {

        homePage
                .clickShoppingCartBadge();
        takeScreenshots
                .takeSnapshot(driver,"Your Cart");
    }
    @Test(dependsOnMethods = "clickShoppingCart")
    public void verify_item_isRemoved(){
        yourCart
                .clickRemoveButton()
                .verify_Item_Removed_From_Cart();
        takeScreenshots
                .takeSnapshot(driver,"Item Removed Screen");
        yourCart
                .click_ContinueShopping_Button();
        addToCart
                .clickAddToCartButton();
        homePage
                .clickShoppingCartBadge();
    }

    @Test(dependsOnMethods = "verify_item_isRemoved")
    public void verify_ItemAdded_to_Cart() {
        yourCart
                .verify_ItemAdded_to_Cart()
                .clickCheckoutButton();
        takeScreenshots
                .takeSnapshot(driver,"Checkout Your information Screen");
    }
    public void verify_Error_Message_for_Empty_Fields(){
        checkoutYourInformation
                .clickContinueButton()
                .verify_Name_Required_ErrorMessage();
    }

    @Test(dependsOnMethods = "verify_ItemAdded_to_Cart")
    public void verify_CaptureInformation_Screen_IsDisplayed(){
        checkoutYourInformation
                .clickContinueButton();
        takeScreenshots
                .takeSnapshot(driver,"Field Required Error Message");
        checkoutYourInformation
                .verify_CaptureInformation_Screen_IsDisplayed()
                .enterName(readFromExcel.name)
                .enterSurname(readFromExcel.surname)
                .EnterPostalCode(readFromExcel.postalCode);
        takeScreenshots
                .takeSnapshot(driver,"Checkout Details");
        checkoutYourInformation
                .clickContinueButton();
        takeScreenshots
                .takeSnapshot(driver,"Checkout Overview");
    }

    @Test(dependsOnMethods = "verify_CaptureInformation_Screen_IsDisplayed")
    public void verify_CheckoutOverview_Screen_isDisplayed(){
        checkoutOverview
                .verify_CheckoutOverview_Screen_isVisible();
    }

    @Test(dependsOnMethods = "verify_CheckoutOverview_Screen_isDisplayed")
    public void verify_Item_IsDisplayed(){
        checkoutOverview
                .verify_Item_isVisible()
                .Verify_itemTotal_Plus_tax_isEqual_to_Total();
        takeScreenshots
                .takeSnapshot(driver,"Logout Screen");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
