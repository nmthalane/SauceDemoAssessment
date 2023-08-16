package Tests;

import Pages.*;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakeScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BaseTests {

    BrowserFactory browserFactory = new BrowserFactory();

    final WebDriver driver = browserFactory.startBrowser("Chrome", "https://www.saucedemo.com");

    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);

    AddToCart addToCart = PageFactory.initElements(driver, AddToCart.class);

    YourCart yourCart = PageFactory.initElements(driver, YourCart.class);

    CheckoutYourInformation checkoutYourInformation = PageFactory.initElements(driver,CheckoutYourInformation.class);

    CheckoutOverview checkoutOverview = PageFactory.initElements(driver, CheckoutOverview.class);

    TakeScreenshots takeScreenshots = PageFactory.initElements(driver, TakeScreenshots.class);
    ReadFromExcel readFromExcel;

    {
        try {
            readFromExcel = new ReadFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
