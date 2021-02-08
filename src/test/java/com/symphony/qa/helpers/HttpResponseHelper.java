package com.symphony.qa.helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class HttpResponseHelper {

    @Step("Check that response's status code is {statusCode}")
    public static void assertStatusCode(Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "The expected status code should be: " + statusCode);
    }

}
