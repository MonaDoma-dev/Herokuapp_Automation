
package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebDriverListener implements WebDriverListener {

    @Attachment(value = "Action Screenshot: {action}", type = "image/png")
    public byte[] captureScreenshot(WebDriver driver, String action) {
        if (driver != null) {
            try {


                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } catch (UnhandledAlertException e) {
                System.out.println("Alert is present, Skipped taking screenshotfor :" + action);
                return new byte[0];
            } catch (Exception e) {
                return new byte[0];
            }
        }
        return new byte[0];
    }


    @Override
    public void afterClick(WebElement element) {
        WebDriver driver = getDriverFromElement(element);
        if (driver != null) {
            captureScreenshot(driver, "Clicked Element");
        }
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriver driver = getDriverFromElement(element);
        if (driver != null) {
            captureScreenshot(driver, "Typed Text");
        }
    }

    private WebDriver getDriverFromElement(WebElement element) {
        try {
            return ((org.openqa.selenium.WrapsDriver) element).getWrappedDriver();
        } catch (Exception e) {
            return null;
        }
    }
}