package utils;

import service.RandomUserService;

import java.util.List;
import java.util.Random;

public class PersonUtil {

    public static String gender;
    public static String firstName;
    public static String lastName;
    public static String city;
    public static String country;
    public static String email;
    public static List<String> hobbies;
    public static String occupation;
    public static String password;
    public static String username;
    public static String zipCode;
    public static String phone;
    public static String streetAdress;

    public PersonUtil() {
        RandomUserService randomUserService = new RandomUserService();
        RequestManager.shared().setResponse(randomUserService.generatingNewPerson());

        gender = setGender();
        firstName = setFirstName();
        lastName = setLastName();
        city = setCity();
        country = setCountry();
        email = setEmail();
        hobbies = setHobbies();
        occupation = setOccupation();
        password = setPassword();
        username = setUsername();
        phone = setPhone();
        streetAdress = setStreetAdress();
        zipCode = setZipCode();
    }

    private final Random rdm = new Random();

    public String setGender() {

        if (RequestManager.getJsonPathToString("results.gender[0]").equalsIgnoreCase("male")) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }

    public String setFirstName() {
        return firstName = RequestManager.getJsonPathToString("results.name.first[0]");
    }

    public String setLastName() {
        return lastName = RequestManager.getJsonPathToString("results.name.last[0]");
    }

    public String setCity() {
        return city = RequestManager.getJsonPathToString("results.location.city[0]");
    }

    public String setCountry() {
        return country = RequestManager.getJsonPathToString("results.location.country[0]");
    }

    public String setEmail() {
        return email = RequestManager.getJsonPathToString("results.email[0]");
    }

    public List<String> setHobbies() {
        return hobbies = List.of("Speeding", "Skydiving");
    }

    public String setOccupation() {
        return occupation = "Employee";
    }

    public String setPassword() {
        return password = RequestManager.getJsonPathToString("results.login.password[0]") + "Ad123";
    }

    public String setPhone() {
        return phone = String.valueOf(rdm.nextInt(999999999));
    }

    public String setStreetAdress() {
        return streetAdress = RequestManager.getJsonPathToString("results.location.street.name[0]");
    }

    public String setUsername() {
        return username = RequestManager.getJsonPathToString("results.login.username[0]");
    }

    public String setZipCode() {
        return zipCode = String.valueOf(rdm.nextInt(88888888));
    }
}
