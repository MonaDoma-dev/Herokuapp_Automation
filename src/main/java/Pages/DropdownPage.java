package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePages {
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) { super(driver); }

    @Step("Select option: {optionText}")
    public void selectOption(String optionText) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(optionText);
        click(dropdown, "Dropdown Option: " + optionText);
    }

    @Step("Get selected option text")
    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}