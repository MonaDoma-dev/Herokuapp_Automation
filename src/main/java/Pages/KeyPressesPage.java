package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePages {
    private final By inputField = By.id("target");
    private final By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) { super(driver); }

    @Step("Press TAB key in input box")
    public void pressTabKey() {
        driver.findElement(inputField).sendKeys(Keys.TAB);
        click(inputField, "Pressed TAB Key");
    }

    @Step("Get key press result text")
    public String getResultText() {
        return getText(resultText, "Key Press Result");
    }
}