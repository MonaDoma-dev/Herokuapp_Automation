package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage extends BasePages {
    private final By addElementBtn = By.xpath("//button[text()='Add Element']");
    private final By deleteBtn = By.className("added-manually");

    public AddRemoveElementsPage(WebDriver driver) { super(driver); }

    @Step("Click Add Element Button")
    public void clickAddElement() {
        click(addElementBtn, "Add Element Button");
    }

    @Step("Verify Delete Button is Visible")
    public boolean isDeleteButtonDisplayed() {
        return driver.findElement(deleteBtn).isDisplayed();
    }
}