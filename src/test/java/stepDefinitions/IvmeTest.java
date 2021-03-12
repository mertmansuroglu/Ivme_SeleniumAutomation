package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.MainLoginPage;
import pageObjects.MeetingPage;
import seleniumFramework.Base;
import seleniumFramework.Utilities;

import java.awt.*;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;

public class IvmeTest extends Base {


    @When("I  visit ivme web page")
    public void iVisitIvmeWebPage() {
        driver.get(prop.getProperty("url"));
    }

    @Then("I check if the page is correctly opened")
    public void iCheckIfThePageIsCorrectlyOpened() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(mp.getLoginForm());
        try {
            Assert.assertTrue(mp.getLoginForm().isDisplayed());

        } catch (Throwable pageNavigationError) {
            throw new Exception("navigated to wrong page");
        }
    }


    @Then("I check if the browser has been closed")
    public void iCheckIfTheBrowserHasBeenClosed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @When("I open guest login link")
    public void iOpenGuestLoginLink() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getLoginGuest().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }

        mp.getLoginGuest().click();
    }

    @Then("I check if the guest login page is correctly opened")
    public void iCheckIfTheGuestLoginPageIsCorrectlyOpened() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);

        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(mp.getGuestLoginZone());

    }

    @When("I enter the valid name in the text box {string}")
    public void iEnterTheValidNameInTheTextBox(String name) throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getLoginInput().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }

        mp.getLoginInput().sendKeys(name);
        Thread.sleep(2000);
    }

    @And("I proceed to sign in Page")
    public void iProceedToSignInPage() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getGuestSignIn().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }

        mp.getGuestSignIn().click();
        Thread.sleep(2000);
    }

    @Then("I check If the login is successful")
    public void iCheckIfTheLoginIsSuccessful() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getcontinueOnBrowser().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }

    }

    @Then("I check if the validation error appeared")
    public void iCheckIfTheValidationErrorAppeared() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getError().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("validation error is missing");
        }
    }

    @Given("I open the  browser {string}")
    public void iOpenTheBrowser(String browser) throws IOException, AWTException {
        driver = driverInitialize(browser);
    }

    @When("I change the language as English")
    public void iChangeTheLanguageAsEnglish() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getLanguageSelector().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }
        Utilities ut = new Utilities(driver);
        ut.moveToElement(mp.getLanguageSelector());
        Thread.sleep(2000);
        mp.getEnLanguage().click();
    }

    @Then("I should be able to be redirected to main login page")
    public void iShouldBeAbleToBeRedirectedToMainLoginPage() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(mp.getLoginForm());
        try {
            Assert.assertTrue(mp.getLoginForm().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }
    }

    @Then("I check the login language as english")
    public void iCheckTheLoginLanguageAsEnglish() {
        MainLoginPage mp = new MainLoginPage(driver);
        Assert.assertTrue(mp.getsignInLabel().getText().equalsIgnoreCase("Sign in to continue"));


    }

    @When("I change the language as turkish")
    public void iChangeTheLanguageAsTurkish() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        try {
            Assert.assertTrue(mp.getLanguageSelector().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }
        Utilities ut = new Utilities(driver);
        ut.moveToElement(mp.getLanguageSelector());
        Thread.sleep(2000);
        mp.getTrLanguage().click();

    }

    @Then("I check the login language as turkish")
    public void iCheckTheLoginLanguageAsTurkish() {
        MainLoginPage mp = new MainLoginPage(driver);
        Assert.assertTrue(mp.getsignInLabel().getText().equalsIgnoreCase("Devam etmek için giriş yapınız"));
    }

    @When("I click continue on browser to attend to meeting")
    public void iClickContinueOnBrowserToAttendToMeeting() throws Exception {
        MainLoginPage mp = new MainLoginPage(driver);
        Utilities ut = new Utilities(driver);
        try {
            ut.checkIfElementIsVisible(mp.getcontinueOnBrowser());
            Assert.assertTrue(mp.getcontinueOnBrowser().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }
        mp.getcontinueOnBrowser().click();
        Thread.sleep(2000);
    }

    @Then("I check if I have navigated to correct page")
    public void iCheckIfIHaveNavigatedToCorrectPage() {
        Utilities ut = new Utilities(driver);
        MeetingPage mp = new MeetingPage(driver);
        ut.checkIfElementIsVisible(mp.getcameraMicrophoneSection());
        Assert.assertTrue(driver.getCurrentUrl().contains("meet"));
    }

    @Then("I check if camera selection dropdown is visible")
    public void iCheckIfCameraSelectionDropdownIsVisible() {
        MeetingPage mp = new MeetingPage(driver);
        //Select Class is typical to selenium
        //we will handle dropdown which is a nature of the select class
        //Select(staticDropdown) burda biz where exactly select dropdown is present!!!
        Utilities ut = new Utilities(driver);
        ut.checkIfElementIsVisible(mp.getCameraSelection());

    }

    @Then("I check if I allowed camera and microphone access")
    public void iCheckIfIAllowedCameraAndMicrophoneAccess() {
        //this step has been handled via chrome options in the base part by sending fake media stream
    }

    @When("I click tamam button to close the device settings")
    public void iClickTamamButtonToCloseTheDeviceSettings() throws Exception {
        MeetingPage mp = new MeetingPage(driver);
        Utilities ut = new Utilities(driver);
        try {
            ut.checkIfElementIsVisible(mp.getTamamButton());
            Assert.assertTrue(mp.getTamamButton().isDisplayed());

        } catch (java.util.NoSuchElementException e) {
            throw new Exception("Error on Page:element not found");
        }
        mp.getTamamButton().click();

    }

    @When("I open a valid {string} from the dropdown")
    public void iOpenAValidFromTheDropdown(String device) throws InterruptedException {
        MeetingPage mp = new MeetingPage(driver);
        switch (device) {
            case "camera":
                Select sdropdown = new Select(mp.getCameraSelection());
                Thread.sleep(3000);
                sdropdown.selectByIndex(2);
                break;
            case "microphone":
                Select sdropdown2 = new Select(mp.getMicSelection());
                sdropdown2.selectByIndex(2);
                break;
            default:
                Assert.fail();

                Thread.sleep(2000);
        }
    }

    @Then("I check if {string} is opened")
    public void iCheckIfIsOpened(String device) {
        MeetingPage mp = new MeetingPage(driver);
        switch (device) {
            case "camera":
                Select sdropdown = new Select(mp.getCameraSelection());

                Assert.assertFalse(sdropdown.getFirstSelectedOption().getText().equalsIgnoreCase("Kamera kullanma"));
                break;
            case "microphone":
                Select sdropdown2 = new Select(mp.getMicSelection());
                Assert.assertFalse(sdropdown2.getFirstSelectedOption().getText().equalsIgnoreCase("Mikrofon kullanma"));
                Assert.assertTrue(sdropdown2.getFirstSelectedOption().getText().contains("Microphone"));
                break;
            default:
                Assert.fail();
        }
    }

    @When("I open a fake {string} from the dropdown")
    public void iOpenAFakeFromTheDropdown(String device) throws InterruptedException {
        Thread.sleep(2000);
        MeetingPage mp = new MeetingPage(driver);
        switch (device) {
            case "camera":
                Select sdropdown = new Select(mp.getCameraSelection());
                sdropdown.selectByIndex(2);
                break;
            case "microphone":
                Select sdropdown2 = new Select(mp.getMicSelection());
                sdropdown2.selectByIndex(2);
                break;
            default:
                Assert.fail();

        }

    }

    @Then("I check if fake {string} is opened")
    public void iCheckIfFakeIsOpened(String device) throws InterruptedException {
        MeetingPage mp = new MeetingPage(driver);
        switch (device) {
            case "camera":
                Select sdropdown = new Select(mp.getCameraSelection());

                Assert.assertFalse(sdropdown.getFirstSelectedOption().getText().equalsIgnoreCase("Kamera kullanma"));
                Assert.assertTrue(sdropdown.getFirstSelectedOption().getText().startsWith("fake"));
                break;
            case "microphone":
                Select sdropdown2 = new Select(mp.getMicSelection());
                Assert.assertFalse(sdropdown2.getFirstSelectedOption().getText().equalsIgnoreCase("Mikrofon kullanma"));
                Assert.assertTrue(sdropdown2.getFirstSelectedOption().getText().startsWith("Fake"));
                break;
            default:
                Assert.fail();
                Thread.sleep(2000);
        }
    }
}
