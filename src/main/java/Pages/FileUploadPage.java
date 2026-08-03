package Pages;

import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePages {
    private final By fileInput = By.id("file-upload");
    private final By uploadBtn = By.id("file-submit");
    private final By uploadedHeading = By.tagName("h3");

    public FileUploadPage(WebDriver driver) { super(driver); }

    @Step("Upload File from path: {filePath}")
    public void uploadFile(String filePath) {
        driver.findElement(fileInput).sendKeys(filePath);
        click(uploadBtn, "Submit File Upload");
    }

    @Step("Get Upload Success Heading")
    public String getUploadedHeading() {
        return getText(uploadedHeading, "Upload Header");
    }
}
