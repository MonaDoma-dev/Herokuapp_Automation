package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePages {
    private final By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) { super(driver); }

    @Step("Right click on Context Menu Box and accept alert")
    public String rightClickAndAcceptAlert() {
        WebElement element = driver.findElement(hotSpot);
        new Actions(driver).contextClick(element).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
