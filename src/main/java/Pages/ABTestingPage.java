package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ABTestingPage extends BasePages {
    private final By heading = By.cssSelector("div.example h3");

    public ABTestingPage(WebDriver driver) { super(driver); }

    @Step("Get A/B Testing Header Text")
    public String getHeaderText() {
        return getText(heading, "A/B Testing Heading");
    }
}