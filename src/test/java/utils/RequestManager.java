package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {

    private static RequestManager sharedInstance;

    private RequestSpecification request;
    private Response response;

    public static synchronized RequestManager shared() {
        if (sharedInstance == null) {
            sharedInstance = new RequestManager();
        }
        return sharedInstance;
    }

    public RequestSpecification getRequest() {
        if (request == null) {
            request = new RequestSpecBuilder().build();
        }
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public void setBaseURI(String uri){
        getRequest().baseUri(uri);
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public static String getJsonPathToString(String jsonPath){
        return shared().getResponse().jsonPath().getJsonObject(jsonPath).toString();
    }
}
