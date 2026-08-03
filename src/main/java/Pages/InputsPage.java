package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputsPage extends BasePages {
    private final By inputField = By.tagName("input");

    public InputsPage(WebDriver driver) { super(driver); }

    @Step("Type number into input: {number}")
    public void enterNumber(String number) {
        type(inputField, number, "Number Input Box");
    }

    @Step("Get Entered Input Value")
    public String getInputValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}