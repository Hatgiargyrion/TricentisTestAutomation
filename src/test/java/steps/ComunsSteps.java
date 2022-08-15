package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.pageobjects.ComunsPO;

public class ComunsSteps {

    private final ComunsPO comunsPA = new ComunsPO();


    @Given("access to Tricentis")
    public void acessUrl(){
        comunsPA.accessingUrl();
    }

    @And("generate a person")
    public void generateAPerson()  {
        comunsPA.generateNewPerson();
    }

    @And("go to tab {string}")
    public void goToTab(String tab)  {
        comunsPA.goingToTab(tab);
    }

    @And("click on {string} button")
    public void clickOnButton(String button)  {
        comunsPA.clickingOnButton(button);
    }

    @Then("validate the message {string}")
    public void validateMessage(String message)  {
        comunsPA.validatingMessage(message);
    }
}
