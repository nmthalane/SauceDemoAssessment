package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

    public static WebDriver driver = null;

    public static WebDriver startBrowser(String browserChoice, String url){

        if("Chrome".equalsIgnoreCase(browserChoice)){

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }else if ("firefox".equalsIgnoreCase(browserChoice)) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        }

        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
//    @Test
//    public void testbrowser(){
//        startBrowser("Chrome", "https://www.saucedemo.com/");
//    }
}
