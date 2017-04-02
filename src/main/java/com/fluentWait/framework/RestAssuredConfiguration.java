package com.fluentWait.framework;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Fluent Wait on 12/10/2016.
 */
public class RestAssuredConfiguration {


    @BeforeSuite(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = "https://www.googleapis.com";
        //RestAssured.port = 8080;
        RestAssured.basePath = "/books";
    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

    public Response getResponse(RequestSpecification requestSpecification,String endpoint, int
                            status){
        Response response = requestSpecification.get(endpoint);
        Assert.assertEquals(response.getStatusCode(),status);
        response.then().log().all();
        return response;
    }

}
