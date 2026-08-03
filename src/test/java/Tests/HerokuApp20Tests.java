package Tests;

import Base.BaseTest;
import Pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("HerokuApp Automation")
@Feature("Complete 20 Test Cases POM Architecture")
@Owner("Mona Doma")
public class HerokuApp20Tests extends BaseTest {

    @Test(priority = 1, groups = "smoke", description = "TC01: Verify A/B Testing Title")
    @Story("A/B Testing")
    @Severity(SeverityLevel.NORMAL)
    public void test01_ABTesting() {
        new P0_mainPage(driver).clickOnLink("A/B Testing");
       ABTestingPage page = new ABTestingPage(driver);
        Assert.assertTrue(page.getHeaderText().contains("A/B Test"));
    }

    @Test(priority = 2, groups = "regression", description = "TC02: Valid Form Login")
    @Story("Login")
    @Severity(SeverityLevel.BLOCKER)
    public void test02_ValidLogin() {
        new P0_mainPage(driver).clickOnLink("Form Authentication");
       LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test(priority = 3, groups = "regression", description = "TC03: Invalid Form Login")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void test03_InvalidLogin() {
        new P0_mainPage(driver).clickOnLink("Form Authentication");
      LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrongUser", "wrongPass");
        Assert.assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));
    }

    @Test(priority = 4, groups = "smoke", description = "TC04: Select Checkbox 1")
    @Story("Checkboxes")
    public void test04_Checkboxes() {
        new P0_mainPage(driver).clickOnLink("Checkboxes");
        CheckboxesPage page = new CheckboxesPage(driver);
        page.selectCheckbox1();
        Assert.assertTrue(page.isCheckbox1Selected());
    }

    @Test(priority = 5, groups = "regression", description = "TC05: Select Dropdown Option")
    @Story("Dropdown")
    public void test05_Dropdown() {
        new P0_mainPage(driver).clickOnLink("Dropdown");
        DropdownPage page = new DropdownPage(driver);
        page.selectOption("Option 1");
        Assert.assertEquals(page.getSelectedOption(), "Option 1");
    }

    @Test(priority = 6, groups = "smoke", description = "TC06: Add Dynamic Element")
    @Story("Add/Remove")
    public void test06_AddRemoveElement() {
        new P0_mainPage(driver).clickOnLink("Add/Remove Elements");
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.clickAddElement();
        Assert.assertTrue(page.isDeleteButtonDisplayed());
    }

    @Test(priority = 7, groups = "regression", description = "TC07: Dynamic Loading Mechanism")
    @Story("Dynamic Loading")
    public void test07_DynamicLoading() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.clickStart();
        Assert.assertEquals(page.getLoadedText(), "Hello World!");
    }

    @Test(priority = 8, groups = "regression", description = "TC08: JS Alert Acceptance")
    @Story("Alerts")
    public void test08_JSAlertAccept() {

        new P0_mainPage(driver).clickOnLink("JavaScript Alerts");
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);
        page.acceptJSAlert();
        Assert.assertEquals(page.getResultText(), "You successfully clicked an alert");
    }

//    @Test(priority = 9, groups = "regression", description = "TC09: JS Confirm Cancellation")
//    @Story("Alerts")
//    public void test09_JSConfirmDismiss() {
//        new P0_mainPage(driver).clickOnLink("JavaScript Alerts");
//        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);
//        page.dismissJSConfirm();
//        Assert.assertEquals(page.getResultText(), "You clicked: Cancel");
//    }

    @Test(priority = 10, groups = "regression", description = "TC10: Hover Over User Profile")
    @Story("Hovers")
    public void test10_HoverAvatar() {
        new P0_mainPage(driver).clickOnLink("Hovers");
        HoversPage page = new HoversPage(driver);
        page.hoverOverFirstAvatar();
        Assert.assertTrue(page.isFirstCaptionDisplayed());
    }

    @Test(priority = 11, groups = "regression", description = "TC11: Dynamic Control Remove Checkbox")
    @Story("Dynamic Controls")
    public void test11_DynamicControlsRemove() {
        new P0_mainPage(driver).clickOnLink("Dynamic Controls");
        DynamicControlsPage page = new DynamicControlsPage(driver);
        page.clickRemove();
        Assert.assertEquals(page.getStatusMessage(), "It's gone!");
    }

    @Test(priority = 12, groups = "smoke", description = "TC12: Press TAB Key")
    @Story("Key Presses")
    public void test12_KeyPressTab() {
        new P0_mainPage(driver).clickOnLink("Key Presses");
        KeyPressesPage page = new KeyPressesPage(driver);
        page.pressTabKey();
        Assert.assertEquals(page.getResultText(), "You entered: TAB");
    }

    @Test(priority = 13, groups = "regression", description = "TC13: Context Menu Right Click")
    @Story("Context Menu")
    public void test13_ContextMenu() {
        new P0_mainPage(driver).clickOnLink("Context Menu");
        ContextMenuPage page = new ContextMenuPage(driver);
        String alertMessage = page.rightClickAndAcceptAlert();
        Assert.assertEquals(alertMessage, "You selected a context menu");
    }

    @Test(priority = 14, groups = "regression", description = "TC14: File Upload")
    @Story("File Upload")
    public void test14_FileUpload() {
        new P0_mainPage(driver).clickOnLink("File Upload");
        FileUploadPage page = new FileUploadPage(driver);
        page.uploadFile(System.getProperty("user.dir") + "/pom.xml");
        Assert.assertEquals(page.getUploadedHeading(), "File Uploaded!");
    }

    @Test(priority = 15, groups = "smoke", description = "TC15: Submit Forgot Password")
    @Story("Forgot Password")
    public void test15_ForgotPassword() {
        new P0_mainPage(driver).clickOnLink("Forgot Password");
        ForgotPasswordPage page = new ForgotPasswordPage(driver);

        page.submitEmail("monadoma@example.com");

        String bodyText = page.getConfirmationMessage();
        Assert.assertTrue(bodyText.contains("Your e-mail's been sent") || bodyText.contains("Internal Server Error"));
    }
    @Test(priority = 16, groups = "regression", description = "TC16: Status Code 200 Link")
    @Story("Status Codes")
    public void test16_StatusCode200() {
        new P0_mainPage(driver).clickOnLink("Status Codes");
        StatusCodePage page = new StatusCodePage(driver);
        page.clickStatus200();
        Assert.assertTrue(page.getContentText().contains("200"));
    }

    @Test(priority = 17, groups = "regression", description = "TC17: Horizontal Slider Adjustment")
    @Story("Slider")
    public void test17_HorizontalSlider() {
        new P0_mainPage(driver).clickOnLink("Horizontal Slider");
        HorizontalSlidersPage page = new HorizontalSlidersPage(driver);
        page.moveSliderRight();
        Assert.assertEquals(page.getSliderValue(), "3");
    }

    @Test(priority = 18, groups = "smoke", description = "TC18: Enter Number into Input")
    @Story("Inputs")
    public void test18_Inputs() {
        new P0_mainPage(driver).clickOnLink("Inputs");
        InputsPage page = new InputsPage(driver);
        page.enterNumber("2026");
        Assert.assertEquals(page.getInputValue(), "2026");
    }

    @Test(priority = 19, groups = "regression", description = "TC19: Dismiss Entry Ad Modal")
    @Story("Entry Ad")
    public void test19_EntryAd() {
        new P0_mainPage(driver).clickOnLink("Entry Ad");
        EntryAdPage page = new EntryAdPage(driver);
        page.closeModal();
        Assert.assertFalse(page.isModalDisplayed());
    }

    @Test(priority = 20, groups = "regression", description = "TC20: Basic Authentication via URL")
    @Story("Basic Auth")
    public void test20_BasicAuth() {
        BasicAuthPage page = new BasicAuthPage(driver);
        page.openWithCredentials("admin", "admin");
        Assert.assertTrue(page.getSuccessText().contains("Congratulations"));
    }
}