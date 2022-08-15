package steps;

import io.cucumber.java.en.And;
import pages.pageobjects.TruckPO;

public class TruckSteps {

    private final TruckPO truckPO = new TruckPO();

    @And("fill out the form {string} in Truck")
    public void fillForm(String form) {
        truckPO.fillingOutForm(form);
    }
}
