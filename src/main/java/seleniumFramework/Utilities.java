package seleniumFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utilities {
    public WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
    }


    public void WaitUntilElementFluent(WebElement element) {
        new WebDriverWait(driver, 10).pollingEvery(Duration.ofMillis(1000)).ignoring(NoSuchElementException.class).ignoring(TimeoutException.class).
                ignoring(Exception.class).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void WaitUntilEelementExplicit(By Byelement) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(Byelement));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void moveToElement(WebElement move) {
        Actions a = new Actions(driver);
        a.moveToElement(move).build().perform();
    }

    public void TakeScreenShot(WebElement element) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileHandler.copy(src, new File("/Users/mertm/Desktop/"));
    }

    public boolean checkIfElementIsVisible(WebElement element) {
        try {
            if (new WebDriverWait(driver, 15).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element)) != null) {
                return true;
            }
        } catch (Exception e) {
            return false;

        }
        return false;
    }

}