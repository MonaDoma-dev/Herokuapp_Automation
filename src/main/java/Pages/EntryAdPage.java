package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EntryAdPage extends BasePages {
    private final By modalCloseBtn = By.xpath("//div[@class='modal-footer']/p");
    private final By modal = By.id("modal");

    public EntryAdPage(WebDriver driver) { super(driver); }

    @Step("Close Ad Modal")
    public void closeModal() {
        wait.until(ExpectedConditions.elementToBeClickable(modalCloseBtn));
        click(modalCloseBtn, "Close Modal Button");
    }

    @Step("Check if Modal is Displayed")
    public boolean isModalDisplayed() {
        return driver.findElement(modal).isDisplayed();
    }
}