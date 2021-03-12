package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seleniumFramework.Base;

public class MainLoginPage extends Base {

    public WebDriver driver;
    By loginGuest = By.cssSelector(".guestTabTitle.guestTabSelector");
    By GuestSignIn = By.xpath("//div[@class='guestLoginZone loginZone']//button[@class='btn btn-red login']");
    By loginInput = By.cssSelector("div.guestLoginZone.loginZone input.inputClass");
    By LoginForm = By.cssSelector("div#loginForm");
    By GuestLoginZone = By.xpath("//div[@class='basicLoginZone loginZone hide'][1]");
    By Trlanguage = By.xpath("//img[@src='/app/webroot/img/trflag.png']");
    By Enlanguage = By.xpath("//img[@src='/app/webroot/img/enflag.png']");
    By languageSelector = By.cssSelector("div.languageSelector");
    By errorValidate = By.cssSelector("div.custom-error");
    By continueOnBrowser = By.cssSelector("a.btn.btn-red.continueOnBrowser");
    By signInLabel = By.cssSelector("span.name-type-info.loginInfo");

    public MainLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginGuest() {
        return driver.findElement(loginGuest);
    }

    public WebElement getLoginInput() {
        return driver.findElement(loginInput);
    }

    public WebElement getLoginForm() {
        return driver.findElement(LoginForm);
    }

    public WebElement getEnLanguage() {
        return driver.findElement(Enlanguage);
    }

    public WebElement getTrLanguage() {
        return driver.findElement(Trlanguage);
    }

    public WebElement getLanguageSelector() {
        return driver.findElement(languageSelector);
    }

    public WebElement getError() {
        return driver.findElement(errorValidate);
    }

    public WebElement getGuestLoginZone() {
        return driver.findElement(GuestLoginZone);
    }

    public WebElement getGuestSignIn() {
        return driver.findElement(GuestSignIn);
    }

    public WebElement getcontinueOnBrowser() {
        return driver.findElement(continueOnBrowser);
    }

    public WebElement getsignInLabel() {
        return driver.findElement(signInLabel);
    }
}

