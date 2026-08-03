package Base;

import Utilities.AllureUtils;
import Utilities.CustomWebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert softAssert;

    @BeforeClass(groups = {"regression", "smoke"})
    public void beforeClass() {
        WebDriver rawDriver = new ChromeDriver();
        CustomWebDriverListener listener = new CustomWebDriverListener();
        this.driver = new EventFiringDecorator<>(listener).decorate(rawDriver);
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod(alwaysRun = true, groups = {"regression", "smoke"})
    public void beforeTC() {
        softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod(alwaysRun = true, groups = {"regression", "smoke"})
    public void afterTC(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureUtils.takeScreenshot(driver, "FAILURE: " + result.getName());
        }
    }

    @AfterClass(groups = {"regression", "smoke"})
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}