package Base;



import Utilities.AllureUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Epic("Herokuapp Automation")
@Feature("Core Functionalities Tests")
public class InternetAppTests extends BaseTest {

    private final String BASE_URL = "https://the-internet.herokuapp.com";

    @Test(priority = 1)
    @Story("Test Case 1: Successful Login")
    public void testSuccessfulLogin() {
        driver.get(BASE_URL + "/login");
        AllureUtils.takeScreenshot(driver, "Opened Login Page");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        AllureUtils.takeScreenshot(driver, "Entered Username");

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        AllureUtils.takeScreenshot(driver, "Entered Password");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        AllureUtils.takeScreenshot(driver, "Clicked Login");

        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));
    }

    @Test(priority = 2)
    @Story("Test Case 2: Unsuccessful Login")
    public void testInvalidLogin() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("invalid");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        AllureUtils.takeScreenshot(driver, "Login Attempt with Invalid Credentials");
        String msg = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("Your username is invalid!"));
    }

    @Test(priority = 3)
    @Story("Test Case 3: Checkboxes Selection")
    public void testCheckboxes() {
        driver.get(BASE_URL + "/checkboxes");
        WebElement cb1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        AllureUtils.takeScreenshot(driver, "Initial Checkbox State");

        if (!cb1.isSelected()) cb1.click();
        AllureUtils.takeScreenshot(driver, "Checked Checkbox 1");
        Assert.assertTrue(cb1.isSelected());
    }

    @Test(priority = 4)
    @Story("Test Case 4: Dropdown Selection")
    public void testDropdown() {
        driver.get(BASE_URL + "/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

        AllureUtils.takeScreenshot(driver, "Selected Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
    }

    @Test(priority = 5)
    @Story("Test Case 5: Add Elements")
    public void testAddElement() {
        driver.get(BASE_URL + "/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        AllureUtils.takeScreenshot(driver, "Added Element");
        WebElement deleteBtn = driver.findElement(By.className("added-manually"));
        Assert.assertTrue(deleteBtn.isDisplayed());
    }

    @Test(priority = 6)
    @Story("Test Case 6: Dynamic Loading")
    public void testDynamicLoading() {
        driver.get(BASE_URL + "/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        AllureUtils.takeScreenshot(driver, "Dynamic Content Loaded");
        String text = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals(text, "Hello World!");
    }

    @Test(priority = 7)
    @Story("Test Case 7: JavaScript Alert")
    public void testJSAlert() {
        driver.get(BASE_URL + "/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        AllureUtils.takeScreenshot(driver, "Accepted Alert");
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test(priority = 8)
    @Story("Test Case 8: JavaScript Confirm")
    public void testJSConfirm() {
        driver.get(BASE_URL + "/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        AllureUtils.takeScreenshot(driver, "Dismissed Confirm Alert");
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test(priority = 9)
    @Story("Test Case 9: Hover User Avatar")
    public void testHovers() {
        driver.get(BASE_URL + "/hovers");
        WebElement avatar = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(avatar).perform();

        AllureUtils.takeScreenshot(driver, "Hovered Over Avatar");
        WebElement caption = driver.findElement(By.xpath("(//div[@class='figcaption'])[1]/h5"));
        Assert.assertTrue(caption.isDisplayed());
    }

    @Test(priority = 10)
    @Story("Test Case 10: Dynamic Controls - Remove Checkbox")
    public void testDynamicControlsRemove() {
        driver.get(BASE_URL + "/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        AllureUtils.takeScreenshot(driver, "Checkbox Removed");
        String msg = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(msg, "It's gone!");
    }

    @Test(priority = 11)
    @Story("Test Case 11: Key Presses")
    public void testKeyPress() {
        driver.get(BASE_URL + "/key_presses");
        driver.findElement(By.id("target")).sendKeys(Keys.TAB);

        AllureUtils.takeScreenshot(driver, "Pressed Tab Key");
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: TAB");
    }

    @Test(priority = 12)
    @Story("Test Case 12: Context Menu (Right Click)")
    public void testContextMenu() {
        driver.get(BASE_URL + "/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();

        AllureUtils.takeScreenshot(driver, "Context Menu Alert Handled");
        Assert.assertEquals(text, "You selected a context menu");
    }

    @Test(priority = 13)
    @Story("Test Case 13: File Upload")
    public void testFileUpload() {
        driver.get(BASE_URL + "/upload");
        // يمكن وضع مسار أي ملف وهمي هنا
        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        uploadInput.sendKeys(System.getProperty("user.dir") + "/pom.xml");

        driver.findElement(By.id("file-submit")).click();
        AllureUtils.takeScreenshot(driver, "Uploaded pom.xml File");

        String header = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(header, "File Uploaded!");
    }

    @Test(priority = 14)
    @Story("Test Case 14: Forgot Password")
    public void testForgotPassword() {
        driver.get(BASE_URL + "/forgot_password");
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("form_submit")).click();

        AllureUtils.takeScreenshot(driver, "Submitted Forgot Password Form");
        Assert.assertTrue(driver.getCurrentUrl().contains("email_sent"));
    }

    @Test(priority = 15)
    @Story("Test Case 15: Status Codes 200")
    public void testStatusCode200() {
        driver.get(BASE_URL + "/status_codes");
        driver.findElement(By.linkText("200")).click();

        AllureUtils.takeScreenshot(driver, "Status Code 200 Page Loaded");
        String content = driver.findElement(By.className("example")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code"));
    }

    @Test(priority = 16)
    @Story("Test Case 16: Horizontal Slider")
    public void testHorizontalSlider() {
        driver.get(BASE_URL + "/horizontal_slider");
        WebElement slider = driver.findElement(By.cssSelector(".sliderContainer input"));

        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);

        AllureUtils.takeScreenshot(driver, "Moved Slider Right");
        String value = driver.findElement(By.id("range")).getText();
        Assert.assertEquals(value, "1");
    }

    @Test(priority = 17)
    @Story("Test Case 17: Inputs Field")
    public void testInputs() {
        driver.get(BASE_URL + "/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("12345");

        AllureUtils.takeScreenshot(driver, "Entered Numbers into Input Field");
        Assert.assertEquals(input.getAttribute("value"), "12345");
    }

    @Test(priority = 18)
    @Story("Test Case 18: Entry Ad Modal Dismissal")
    public void testEntryAd() {
        driver.get(BASE_URL + "/entry_ad");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-footer']/p")));

        AllureUtils.takeScreenshot(driver, "Modal Displayed");
        closeBtn.click();

        AllureUtils.takeScreenshot(driver, "Modal Dismissed");
        Assert.assertFalse(driver.findElement(By.id("modal")).isDisplayed());
    }

    @Test(priority = 19)
    @Story("Test Case 19: Dynamic Controls Enable Input")
    public void testDynamicControlsEnable() {
        driver.get(BASE_URL + "/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        AllureUtils.takeScreenshot(driver, "Input Enabled");
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        Assert.assertTrue(input.isEnabled());
    }

    @Test(priority = 20)
    @Story("Test Case 20: Disappearing Elements")
    public void testDisappearingElements() {
        driver.get(BASE_URL + "/disappearing_elements");

        AllureUtils.takeScreenshot(driver, "Disappearing Elements Loaded");
        WebElement title = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(title.getText(), "Disappearing Elements");
    }
}
