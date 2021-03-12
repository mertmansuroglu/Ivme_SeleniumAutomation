package seleniumFramework;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    public Properties prop = new Properties();

    public WebDriver driverInitialize(String browserName) throws IOException, AWTException {
        //based on browser we should run the below
        System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        //load is method which can take fis as argument
        prop.load(fis);
        if (browserName.equals("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("use-fake-ui-for-media-stream");
            System.setProperty("webdriver.chrome.driver", "/Users/mertm/Desktop/chromedriver");
            driver = new ChromeDriver(option);
        } else if (browserName.equals("firefox")) {
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("use-fake-ui-for-media-stream");
            option.addPreference("media.navigator.permission.disabled", true);
            System.setProperty("webdriver.gecko.driver", "/Users/mertm/Desktop/geckodriver");
            driver = new FirefoxDriver(option);
        } else if (browserName.equals("ChromeFakeMicAndCam")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("use-fake-ui-for-media-stream");
            option.addArguments("--use-fake-device-for-media-stream");
            System.setProperty("webdriver.chrome.driver", "/Users/mertm/Desktop/chromedriver");
            driver = new ChromeDriver(option);
        } else {
            Assert.fail();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}

