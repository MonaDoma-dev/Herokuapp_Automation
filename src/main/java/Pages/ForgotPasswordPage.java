package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage extends BasePages {

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.id("email");
    private final By submitBtn = By.id("form_submit");
    private final By pageContent = By.tagName("body");

    @Step("Submit Email")
    public void submitEmail(String email) {
        type(emailField, email, "Email Field");
        click(submitBtn, "Retrieve Password Button");
    }

    @Step("Get Confirmation Message")
    public String getConfirmationMessage() {

        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        customWait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElementLocated(pageContent, "Your e-mail's been sent"),
                ExpectedConditions.textToBePresentInElementLocated(pageContent, "Internal Server Error")
        ));

        return getText(pageContent, "Page Content");
    }
}