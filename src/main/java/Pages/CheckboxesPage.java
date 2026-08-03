package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckboxesPage extends BasePages {
    private final By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");
    public CheckboxesPage(WebDriver driver) { super(driver); }

    @Step("Check the first checkbox if unchecked")
    public void selectCheckbox1() {
        if (!wait.until(ExpectedConditions.presenceOfElementLocated(checkbox1)).isSelected()) {
            click(checkbox1, "Checkbox 1");
        }
    }

    @Step("Verify Checkbox 1 Selection Status")
    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }
}