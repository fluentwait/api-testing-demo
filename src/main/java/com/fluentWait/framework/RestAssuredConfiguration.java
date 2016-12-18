package com.fluentWait.framework;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Fluent Wait on 12/10/2016.
 */
public class RestAssuredConfiguration {


    @BeforeSuite(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/SprintRestServices";
    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

}
