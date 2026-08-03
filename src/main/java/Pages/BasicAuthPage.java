package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class BasicAuthPage extends BasePages {
    private final By successMessage = By.cssSelector("div.example p");

    public BasicAuthPage(WebDriver driver) { super(driver); }

    @Step("Navigate with Basic Auth Credentials")
    public void openWithCredentials(String user, String pass) {
        driver.get("https://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
    }

    @Step("Get Basic Auth Success Text")
    public String getSuccessText() {
        return getText(successMessage, "Basic Auth Message");
    }
}
