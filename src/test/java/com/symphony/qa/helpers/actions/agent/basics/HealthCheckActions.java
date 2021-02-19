package com.symphony.qa.helpers.actions.agent.basics;

import com.symphony.api.SystemApi;
import com.symphony.api.client.ApiClient;
import com.symphony.qa.helpers.HttpResponseHelper;
import com.symphony.qa.helpers.JsonDataHelper;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.symphony.api.client.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class HealthCheckActions {

    @Step("I retrieve a the v2 health check endpoint")
    public Response IRetrieveV2HealthCheckEndpoint() {
        SystemApi systemApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(System.getenv("AUTOMATED_AGENT_BASEURL"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).system();
        return systemApi.v2HealthCheckGet().execute(r -> r);
    }

    @Step("I assert the HealthCheck fields")
    public void IAssertAllV2HealthCheckSuccessfulFields(Response response){
        HttpResponseHelper.assertStatusCode(response, 200);
        JsonDataHelper.assertTrue("podConnectivity", response.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", response.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", response.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", response.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", response.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", response.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", response.getBody().path("ceServiceUser"));
    }
}
