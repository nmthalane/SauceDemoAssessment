package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

import static Utils.BrowserFactory.driver;

public class ExtentReportManager {

    public static Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    private static String homedir = System.getProperty("user.dir");

    private static String reportDir = homedir + "/src/test/Reports/ExtentReport.html";

    public static ExtentReports extentSetup() {
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Extent Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Automation Report");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Username", System.getProperty("user.name"));
        extentReports.setSystemInfo("Browser Name", cap.getBrowserName());
        extentReports.setSystemInfo("Browser Version", cap.getBrowserVersion());
        extentReports.setSystemInfo("Url", ("https://www.saucedemo.com/"));

        return extentReports;
    }

}
