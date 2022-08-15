package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.RequestManager;

public class BaseService {

    public Response doGetRequest() {
        return RestAssured.given()
                .spec(RequestManager.shared().getRequest())
                .when()
                .get();
    }
}
