package service;

import io.restassured.response.Response;
import utils.RequestManager;

public class RandomUserService extends BaseService{

    private static final String BASE_URI = "https://randomuser.me/api/";

    public RandomUserService() {
        RequestManager.shared().setBaseURI(BASE_URI);
    }

    public Response generatingNewPerson() {
        return doGetRequest();
    }
}
