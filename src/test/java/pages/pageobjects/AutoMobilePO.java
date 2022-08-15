package pages.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DateGeneratorUtil;
import utils.PersonUtil;

import java.util.List;

public class AutoMobilePO extends PageObject {

    //Form Vehicle Data
    @FindBy(id = "make")
    private WebElement comboMake;
    @FindBy(id = "engineperformance")
    private WebElement comboEnginePerformance;
    @FindBy(id = "dateofmanufacture")
    private WebElement fieldDateManufacture;
    @FindBy(id = "numberofseats")
    private WebElement comboNumbersSeats;
    @FindBy(id = "fuel")
    private WebElement comboFuelType;
    @FindBy(id = "listprice")
    private WebElement comboListPrice;
    @FindBy(id = "licenseplatenumber")
    private WebElement comboLicensePlateNumber;
    @FindBy(id = "annualmileage")
    private WebElement comboAnnualMileage;

    //Form Insurant Data
    @FindBy(id = "firstname")
    private WebElement fieldFirstName;
    @FindBy(id = "lastname")
    private WebElement fieldLastName;
    @FindBy(id = "birthdate")
    private WebElement fieldDateOfBirth;
    @FindBy(id = "streetaddress")
    private WebElement fieldStreetAddress;
    @FindBy(id = "country")
    private WebElement comboCountry;
    @FindBy(id = "zipcode")
    private WebElement fieldZipCode;
    @FindBy(id = "city")
    private WebElement fieldCity;
    @FindBy(id = "occupation")
    private WebElement comboOccupation;

    //Form Product Data
    @FindBy(id = "startdate")
    private WebElement fieldStartDate;
    @FindBy(id = "insurancesum")
    private WebElement comboInsuranceSum;
    @FindBy(id = "meritrating")
    private WebElement comboMeritRating;
    @FindBy(id = "damageinsurance")
    private WebElement comboDamageInsurance;
    @FindBy(id = "courtesycar")
    private WebElement comboCourtesyCar;

    //Form Select Price Option
    @FindBy(xpath = "//input[@id='selectultimate']/../span")
    private WebElement rdoUltimate;

    //Form Send Quote
    @FindBy(id = "email")
    private WebElement fieldEmail;
    @FindBy(id = "phone")
    private WebElement fieldPhone;
    @FindBy(id = "username")
    private WebElement fieldUsername;
    @FindBy(id = "password")
    private WebElement fieldPassword;
    @FindBy(id = "confirmpassword")
    private WebElement fieldConfirmPassword;
    @FindBy(id = "Comments")
    private WebElement fieldComments;

    private final DateGeneratorUtil dateGeneratorUtil = new DateGeneratorUtil();
    private PersonUtil personUtil;

    public void fillingOutForm(String form) {
        switch (form.toLowerCase()) {
            case "enter vehicle data" -> fillingOutFormVehicleData();
            case "enter insurant data" -> fillingOutFormInsurantData();
            case "enter product data" -> fillingOutFormProductData();
            case "select price option" -> fillingOutFormPriceOption();
            case "send quote" -> fillingOutFormSendQuote();
            default -> throw new IllegalArgumentException("The " + form + " form provided does not exist on the switch");
        }
    }

    public void fillingOutFormVehicleData() {
        selectInCombo(comboMake, "Volkswagen");
        sendKeys(comboEnginePerformance, "169.9002");
        sendKeys(fieldDateManufacture, dateGeneratorUtil.generatingDate("random"));
        selectInCombo(comboNumbersSeats, "5");
        selectInCombo(comboFuelType, "Electric Power");
        sendKeys(comboListPrice, "96000");
        sendKeys(comboLicensePlateNumber, "QTP5F71");
        sendKeys(comboAnnualMileage, "5000");
    }

    public void fillingOutFormInsurantData() {

        sendKeys(fieldFirstName, PersonUtil.firstName);
        sendKeys(fieldLastName, PersonUtil.lastName);
        sendKeys(fieldDateOfBirth, dateGeneratorUtil.generatingDate("birth"));
        selectCheckBox(PersonUtil.gender);
        sendKeys(fieldStreetAddress, personUtil.streetAdress);
        selectInCombo(comboCountry, PersonUtil.country);
        sendKeys(fieldZipCode, PersonUtil.zipCode);
        sendKeys(fieldCity, PersonUtil.city);
        selectInCombo(comboOccupation, PersonUtil.occupation);
        multiSelectCheckBox(PersonUtil.hobbies);
    }

    public void fillingOutFormProductData() {
        List<String> products = List.of("Euro Protection", "Legal Defense Insurance");
        sendKeys(fieldStartDate, dateGeneratorUtil.generatingDate("m+1"));
        selectInCombo(comboInsuranceSum, "10000000");
        selectInCombo(comboMeritRating, "Bonus 9");
        selectInCombo(comboDamageInsurance, "Full Coverage");
        multiSelectCheckBox(products);
        selectInCombo(comboCourtesyCar, "Yes");
    }

    public void fillingOutFormPriceOption() {
        click(rdoUltimate);
    }

    public void fillingOutFormSendQuote() {
        sendKeys(fieldEmail, PersonUtil.email);
        sendKeys(fieldPhone, PersonUtil.phone);
        sendKeys(fieldUsername, PersonUtil.username);
        sendKeys(fieldPassword, PersonUtil.password);
        sendKeys(fieldConfirmPassword, PersonUtil.password);
        sendKeys(fieldComments, "Test Automation");
    }
}
