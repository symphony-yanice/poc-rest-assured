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

    @Step("I retrieve the v2 health check endpoint")
    public Response IRetrieveV3HealthCheckEndpoint() {
        SystemApi systemApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(System.getenv("AUTOMATED_AGENT_BASEURL"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).system();
        return systemApi.v3ExtendedHealth().execute(r -> r);
    }

    @Step("I assert the HealthCheck successful fields")
    public void IAssertAllV3HealthCheckSuccessfulFields(Response response){
        HttpResponseHelper.assertStatusCode(response, 200);
        JsonDataHelper.assertEquals("status", response.getBody().path("status"), "UP");
        JsonDataHelper.assertEquals("version", response.getBody().path("version"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertEquals("pod status", response.getBody().path("services.pod.status"), "UP");
        JsonDataHelper.assertEquals("pod version", response.getBody().path("services.pod.version"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("key manager status", response.getBody().path("services.key_manager.status"), "UP");
        JsonDataHelper.assertEquals("key manager version", response.getBody().path("services.key_manager.version"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("users agentservice status", response.getBody().path("users.agentservice.status"), "UP");
        JsonDataHelper.assertEquals("users agentservice authType", response.getBody().path("users.agentservice.authType"), "RSA");
        JsonDataHelper.assertEquals("users ceservice status", response.getBody().path("users.ceservice.status"), "UP");
        JsonDataHelper.assertEquals("users ceservice authType", response.getBody().path("users.ceservice.authType"), "RSA");
    }
}
