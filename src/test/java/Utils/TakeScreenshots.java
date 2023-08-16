package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {

    private static ExtentReports extent;
    private static ExtentTest test;

    private static String homedir = System.getProperty("user.dir");

    private static String reportDir = homedir + "/src/test/Reports/ExtentReport.html";

        public void takeSnapshot(WebDriver driver, String screenshotName) {
        extent = new ExtentReports();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String homeDir = System.getProperty("user.dir") + "/src/test/Screenshots/" + screenshotName + ".png";

        File destination = new File(homeDir);

        try {
            FileUtils.copyFile(src, destination);
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
