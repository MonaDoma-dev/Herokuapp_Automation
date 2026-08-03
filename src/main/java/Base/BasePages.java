package Base;

import Utilities.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Click on: {elementName}")
    public void click(By locator, String elementName) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        AllureUtils.takeScreenshot(driver, "Clicked: " + elementName);
    }

    @Step("Type '{text}' into: {elementName}")
   public void type(By locator, String text, String elementName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        AllureUtils.takeScreenshot(driver, "Entered: " + elementName);
    }

    @Step("Get text from: {elementName}")
    public String getText(By locator, String elementName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = element.getText();
        AllureUtils.takeScreenshot(driver, "Read Text from: " + elementName);
        return text;
    }
}