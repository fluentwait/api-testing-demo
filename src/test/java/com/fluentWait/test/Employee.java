package com.fluentWait.test;

import com.fluentWait.common.EndPoint;
import com.fluentWait.framework.RestAssuredConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

/**
 * Created by Fluent Wait on 12/10/2016.
 */
public class Employee {

    @Test(groups = "demo")
    public void validateEmployee() {
        given().get(EndPoint.GET_EMPLOYEE).then().statusCode(200).log().all();
    }

    //http://localhost:8080/SprintRestServices/employee/getEmployeeQuery?employeeId=100
    @Test(groups = "demo")
    public void validateQueryParameter() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("employeeId", 200).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_EMPLOYEE_QUERY_PARAM);

    }

    //http://localhost:8080/SprintRestServices/employee/getEmployee/100
    @Test(groups = "demo")
    public void validatePathParameter() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.pathParam("employeeId", 100).log().all();
        given().spec(requestSpecification).get(EndPoint.GET_EMPLOYEE_PATH_PARAM).
                then().statusCode(200).log().all();
    }
    
    //http://localhost:8080/SprintRestServices/employee/addEmployee
    @Test(groups = "demo")
    public void validateFormParameters() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.accept(ContentType.JSON).formParams("employeeId", 100).log().all();
        given().spec(requestSpecification).post(EndPoint.POST_EMPLOYEE_PARAM).
                then().statusCode(200).log().all();
    }
}
