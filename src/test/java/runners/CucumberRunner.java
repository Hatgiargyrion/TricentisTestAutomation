package runners;

import core.WebDriverConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = "steps",
        plugin = {"pretty", "json:target/cucumber-reports/CucumberJson.json"},
        monochrome = true,
        tags = "@automobile_insurance")
public class CucumberRunner {

    private static final WebDriverConfig webDriverConfig = new WebDriverConfig();

    @BeforeClass
    public static void config() {
        webDriverConfig.initializeDriver("chrome").defaultConfig();
    }

    @AfterClass
    public static void afterMethod(){
        webDriverConfig.closeBrowser();
    }
}