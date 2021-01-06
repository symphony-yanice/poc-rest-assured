package com.symphony.qa.helpers;

import io.restassured.response.Response;
import org.testng.Assert;

public class HttpResponseHelper {

    public static void assertStatusCode(Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "The expected status code should be: " + statusCode);
    }

}
