package Pages;

import Base.BasePages;
import aj.org.objectweb.asm.ClassReader;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class  JavaScriptAlertsPage extends BasePages {
    private final By jsAlertBtn = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private final By jsConfirmBtn = By.xpath("//button[text(),'Click for JS Confirm']");
    private final By resultText = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) { super(driver); }

    @Step("Trigger and Accept JS Alert")
    public void acceptJSAlert() {

        WebElement element = driver.findElement(jsAlertBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = customWait.until(ExpectedConditions.alertIsPresent());


        alert.accept();
    }

    @Step("Trigger and Dismiss JS Confirm")
    public void dismissJSConfirm() {
        click(jsConfirmBtn, "JS Confirm Button");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Step("Get Alert Result Text")
    public String getResultText() {
        return getText(resultText, "Result Message");
    }
}
