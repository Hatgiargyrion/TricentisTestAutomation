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

    public WebDriverConfig initializeDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.chrome.driver", "drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Navegador não suportado: " + browser);
            }
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


