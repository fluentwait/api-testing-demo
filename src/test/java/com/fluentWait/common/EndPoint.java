package com.fluentWait.common;

/**
 * Created by Fluent Wait on 12/10/2016.
 */
public interface EndPoint {

    String GET_EMPLOYEE = "/employee/getEmployee";

    String GET_ALL="/employee/getAll";
    String GET_EMPLOYEE_PATH_PARAM ="/employee/getEmployee/{employeeId}";
    String GET_EMPLOYEE_QUERY_PARAM = "/employee/getEmployeeQuery";
    String POST_EMPLOYEE_PARAM = "/employee/addEmployee";

    String GOOGLE_API = "/v1/volumes";
}
