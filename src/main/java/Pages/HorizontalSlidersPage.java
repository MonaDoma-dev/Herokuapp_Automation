package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSlidersPage extends BasePages {
    private final By slider = By.cssSelector(".sliderContainer input");
    private final By rangeValue = By.id("range");

    public HorizontalSlidersPage(WebDriver driver) { super(driver); }

    @Step("Move Slider Right")
    public void moveSliderRight() {
        driver.findElement(slider).click();
        driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
       // click(slider, "Moved Slider Right");
    }

    @Step("Get Current Slider Value")
    public String getSliderValue() {
        return getText(rangeValue, "Slider Range Value");
    }
}
