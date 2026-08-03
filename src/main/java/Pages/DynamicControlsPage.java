package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePages {
    private final By removeBtn = By.xpath("//button[text()='Remove']");
    private final By enableBtn = By.xpath("//button[text()='Enable']");
    private final By message = By.id("message");
    private final By inputField = By.xpath("//form[@id='input-example']/input");

    public DynamicControlsPage(WebDriver driver) { super(driver); }

    @Step("Click Remove Button")
    public void clickRemove() {
        click(removeBtn, "Remove Checkbox Button");
    }

    @Step("Click Enable Input Button")
    public void clickEnable() {
        click(enableBtn, "Enable Input Button");
    }

    @Step("Get Status Message Text")
    public String getStatusMessage() {
        return getText(message, "Status Message");
    }

    @Step("Check if Input Field is Enabled")
    public boolean isInputEnabled() {
        return driver.findElement(inputField).isEnabled();
    }
}