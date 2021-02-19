package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.helpers.actions.agent.basics.HealthCheckActions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;

@Epic("Agent")
@Feature("Basics")
@Story("Health Checks")
@Execution(ExecutionMode.CONCURRENT)
public class BasicTest {

    @Test
    @DisplayName("test Health V2")
    @Description("This scenario is an example of Actions capabilities with cucumber")
    @Issue("PLAT-10399")
    public void testHealthV2() {
        HealthCheckActions healthCheckActions = new HealthCheckActions();
        Response getHealthCheckResponse = healthCheckActions.IRetrieveV2HealthCheckEndpoint();
        healthCheckActions.IAssertAllV2HealthCheckSuccessfulFields(getHealthCheckResponse);
    }

}
