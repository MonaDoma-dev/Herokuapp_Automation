package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodePage extends BasePages {
    private final By status200Link = By.linkText("200");
    private final By contentArea = By.className("example");

    public StatusCodePage(WebDriver driver) { super(driver); }

    @Step("Click Code 200 Link")
    public void clickStatus200() {
        click(status200Link, "Status Code 200 Link");
    }

    @Step("Get Status Code Description Text")
    public String getContentText() {
        return getText(contentArea, "Status Code Page Content");
    }
}