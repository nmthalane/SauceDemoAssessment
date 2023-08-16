package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutYourInformation {

    WebDriver driver = null;
    @FindBy(xpath = "//span[contains(.,'Checkout: Your Information')]")
    WebElement checkoutInformation;
    @FindBy(id = "first-name")
    WebElement firstName_id;
    @FindBy(id = "last-name")
    WebElement lastName_id;
    @FindBy(id = "postal-code")
    WebElement postalCode_id;

    @FindBy(id = "continue")
    WebElement continueButton_id;
    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Error: First Name is required')]")
    WebElement nameRequiredError_xpath;

    public CheckoutYourInformation(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutYourInformation verify_CaptureInformation_Screen_IsDisplayed() {

        String captureScreenIsDisplayed = checkoutInformation.getText();
        Assert.assertEquals(captureScreenIsDisplayed, "Checkout: Your Information");

        return this;
    }

    public CheckoutYourInformation enterName(String name) {
        firstName_id.clear();
        firstName_id.sendKeys(name);

        return this;
    }

    public CheckoutYourInformation enterSurname(String surname) {
        lastName_id.clear();
        lastName_id.sendKeys(surname);

        return this;
    }

    public CheckoutYourInformation EnterPostalCode(String postalCode) {
        postalCode_id.clear();
        postalCode_id.sendKeys(postalCode);

        return this;
    }

    public CheckoutYourInformation verify_Name_Required_ErrorMessage() {

        String nameRequiredError = nameRequiredError_xpath.getText();
        Assert.assertEquals(nameRequiredError, "Error: First Name is required");

        return this;
    }

    public CheckoutYourInformation clickContinueButton() {
        continueButton_id.click();

        return this;
    }

}
