package com.symphony.qa.integration;

import com.symphony.api.DatafeedApi;
import com.symphony.api.MessagesApi;
import com.symphony.api.SignalsApi;
import com.symphony.api.SystemApi;
import com.symphony.api.client.ApiClient;
import com.symphony.qa.configuration.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static com.symphony.api.client.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class BaseTest {

    protected Config config;
    protected SystemApi systemApi;
    protected SignalsApi signalsApi;
    protected MessagesApi messagesApi;
    protected DatafeedApi datafeedApi;

    @BeforeEach
    public void setup() throws IOException {
        this.config = new Config();
        this.systemApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(this.config.getProperty("api.agent.baseurl"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).system();
        this.signalsApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(this.config.getProperty("api.agent.baseurl"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).signals();
        this.messagesApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(this.config.getProperty("api.agent.baseurl"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).messages();
        this.datafeedApi = ApiClient.api(ApiClient.Config.apiConfig().reqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setConfig(config().objectMapperConfig(objectMapperConfig().defaultObjectMapper(gson())))
                        .addFilter(new ErrorLoggingFilter())
                        .setBaseUri(this.config.getProperty("api.agent.baseurl"))
                        .setContentType(ContentType.JSON)
                        .setRelaxedHTTPSValidation()
        )).datafeed();
    }
}
