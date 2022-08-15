package pages.pageobjects;

import core.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PageObject {

    public PageObject() {
        PageFactory.initElements(WebDriverConfig.getDriver(), this);
    }

    public WebElement $xpath(String element) {
        return WebDriverConfig.getDriver().findElement(By.xpath(element));
    }

    public WebElement $css(String element) {
        return WebDriverConfig.getDriver().findElement(By.cssSelector(element));
    }

    public WebElement expectedConditionsClickable(WebElement element) {
        return WebDriverConfig.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement expectedConditionsVisible(WebElement element) {
        return WebDriverConfig.getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean isDisplayed(WebElement element) {
        return expectedConditionsVisible(element).isDisplayed();
    }

    public void click(WebElement element) {
        WebElement elementClick = expectedConditionsClickable(element);
        expectedConditionsVisible(elementClick);
        elementClick.click();
    }

    public void sendKeys(WebElement element, String key) {
        click(element);
        expectedConditionsClickable(element).sendKeys(key);
    }

    public void selectInCombo(WebElement element, String key) {
        click(element);
        click($css("section[style='display: block;'] option[value='" + key + "']"));
    }

    public void selectCheckBox(String key) {
        click($xpath("//section[@style='display: block;']//label[normalize-space()='" + key + "']/span"));
    }

    public void multiSelectCheckBox(List<String> key) {
        key.forEach(this::selectCheckBox);
    }
}
