package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MeetingPage {
    public WebDriver driver;
    By tamamButton = By.cssSelector("button.btn.btn-primary.ng-binding");
    By cameraSelectButton = By.xpath("//select[@ng-model='media.selectedCamera']");
    By microphoneSelectButton = By.xpath("//select[@ng-model='media.selectedMicrophone']");
    By cameraMicrophoneSection = By.xpath("//li[@select='settingsVm.tabSelect(0);']");
    By arrangeScreenSection = By.xpath("//li[@select='settingsVm.tabSelect(1);']");
    By kutuGorunum = By.xpath("//div[@ng-class=\"{'selected-layout': layoutSelectionVm.scrollableVirtualClassroomSelected}\"]");
    By aktifGorunum = By.xpath("//div[@ng-class=\"{'selected-layout': layoutSelectionVm.dynamicSelected}\"]");

    public MeetingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCameraSelection() {
        return driver.findElement(cameraSelectButton);
    }

    public WebElement getTamamButton() {
        return driver.findElement(tamamButton);
    }

    public WebElement getMicSelection() {
        return driver.findElement(microphoneSelectButton);
    }

    public WebElement getcameraMicrophoneSection() {
        return driver.findElement(cameraMicrophoneSection);
    }

    public WebElement getarrangeScreenSection() {
        return driver.findElement(arrangeScreenSection);
    }

    public WebElement getkutuGorunum() {
        return driver.findElement(kutuGorunum);
    }

    public WebElement getaktifGorunum() {
        return driver.findElement(aktifGorunum);
    }
}
