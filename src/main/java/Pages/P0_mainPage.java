
package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P0_mainPage extends BasePages {
    public P0_mainPage(WebDriver driver) { super(driver); }

    @Step("Navigate to section: {linkText}")
    public void clickOnLink(String linkText) {
        click(By.linkText(linkText), linkText + " Link");
    }
}