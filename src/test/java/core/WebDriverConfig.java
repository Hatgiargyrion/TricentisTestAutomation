package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverConfig {

    public static final Dimension DEFAULT_SCREEN_SIZE = new Dimension(1280, 720);

    private static WebDriver driver;
    private static WebDriverWait wait;

    public WebDriverConfig setUpBrowser(String browser){
        System.setProperty("webdriver.gecko.driver", "../tricentisAutomation/src/test/java/core/drivers/geckdriver.exe");
        System.setProperty("webdriver.chrome.driver", "../tricentisAutomation/src/test/java/core/drivers/chromedriver.exe");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return this;
    }

    public void defaultConfig() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().setSize(DEFAULT_SCREEN_SIZE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    public void closeBrowser() {
        driver.close();
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


