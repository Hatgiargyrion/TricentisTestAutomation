package pages.pageobjects;

import core.WebDriverConfig;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PersonUtil;

public class ComunsPO extends PageObject {

    //Tabs
    @FindBy(id = "entervehicledata")
    private WebElement tabEnterVehicleData;
    @FindBy(id = "enterinsurantdata")
    private WebElement tabEnterInsurantData;
    @FindBy(id = "enterproductdata")
    private WebElement tabEnterProductData;
    @FindBy(id = "selectpriceoption")
    private WebElement tabSelectPriceOption;
    @FindBy(id = "sendquote")
    private WebElement sendQuote;

    //Tabs Menu
    @FindBy(css = ".main-navigation #nav_automobile")
    private WebElement tabAutomobile;
    @FindBy(css = ".main-navigation #nav_truck")
    private WebElement tabTruck;
    @FindBy(css = ".main-navigation #nav_Motorcycle")
    private WebElement tabMotorcycle;
    @FindBy(css = ".main-navigation #nav_Camper")
    private WebElement tabCamper;

    public void accessingUrl() {
        WebDriverConfig.getDriver().navigate().to("http://sampleapp.tricentis.com/101/app.php");
    }

    public void generateNewPerson() {
        new PersonUtil();
    }

    public void goingToTab(String tab) {
        switch (tab.toLowerCase()) {
            case "enter vehicle data" -> click(tabEnterVehicleData);
            case "enter insurant data" -> click(tabEnterInsurantData);
            case "enter product data" -> click(tabEnterProductData);
            case "select price option" -> click(tabSelectPriceOption);
            case "send quote" -> click(sendQuote);
            case "automobile" -> click(tabAutomobile);
            case "truck" -> click(tabTruck);
            case "motorcycle" -> click(tabMotorcycle);
            case "camper" -> click(tabCamper);
            default -> throw new IllegalArgumentException("The " + tab + " tab provided does not exist on the switch");
        }
    }

    public void clickingOnButton(String button) {
        click($xpath("//section[@style='display: block;']//button[contains(.,'" + button + "')]"));
    }

    public void validatingMessage(String message) {
        try {
            Assert.assertTrue(isDisplayed($xpath("//div[contains(@class,'sa-success')]/../h2[normalize-space()='" + message + "']")));
        } catch (AssertionError e) {
            throw new AssertionError("Message '" + message + "' is not present in the suggested element");
        }
    }
}

