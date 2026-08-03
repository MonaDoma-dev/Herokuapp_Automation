package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePages {
    private final By startBtn = By.cssSelector("#start button");
    private final By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) { super(driver); }

    @Step("Click Start Loading Button")
    public void clickStart() {
        click(startBtn, "Start Button");
    }

    @Step("Wait and get loaded text")
    public String getLoadedText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishText));
        return getText(finishText, "Loaded Result Text");
    }
}