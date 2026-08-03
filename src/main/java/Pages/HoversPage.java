package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends BasePages {
    private final By firstAvatar = By.xpath("(//img[@alt='User Avatar'])[1]");
    private final By firstCaption = By.xpath("(//div[@class='figcaption'])[1]/h5");

    public HoversPage(WebDriver driver) { super(driver); }

    @Step("Hover over first user avatar")
    public void hoverOverFirstAvatar() {
        WebElement avatar = driver.findElement(firstAvatar);
        new Actions(driver).moveToElement(avatar).perform();
        click(firstAvatar, "First User Avatar Hover");
    }

    @Step("Verify Avatar Caption is Displayed")
    public boolean isFirstCaptionDisplayed() {
        return driver.findElement(firstCaption).isDisplayed();
    }
}