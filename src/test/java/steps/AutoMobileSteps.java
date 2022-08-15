package steps;

import io.cucumber.java.en.And;
import pages.pageobjects.AutoMobilePO;

public class AutoMobileSteps {

    private final AutoMobilePO autoMobilePO = new AutoMobilePO();

    @And("fill out the form {string} in Automobile")
    public void fillForm(String form) {
        autoMobilePO.fillingOutForm(form);
    }
}
