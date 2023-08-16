package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver = null;
    @FindBy(id = "user-name")
    WebElement username_id;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(id = "login-button")
    WebElement loginButton_id;

    @FindBy(xpath = "//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement loginUnsuccessful_xpath;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public LoginPage enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(username_id));

        username_id.clear();
        username_id.sendKeys(username);

        return this;
    }

    public LoginPage enterPassword(String password) {
        password_id.clear();
        password_id.sendKeys(password);

        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton_id.click();
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin() {

        String loginUnsuccessful = loginUnsuccessful_xpath.getText();
        Assert.assertEquals(loginUnsuccessful, "Epic sadface: Username and password do not match any user in this service");

        return this;
    }

}
