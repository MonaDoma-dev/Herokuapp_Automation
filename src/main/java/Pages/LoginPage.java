package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePages {
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) { super(driver); }

    @Step("Perform Login with username: {username}")
    public void login(String username, String password) {
        type(usernameField, username, "Username Input");
        type(passwordField, password, "Password Input");
        click(loginButton, "Login Button");
    }

    @Step("Get Login Banner Message")
    public String getFlashMessage() {
        return getText(flashMessage, "Flash Message Banner");
    }
}