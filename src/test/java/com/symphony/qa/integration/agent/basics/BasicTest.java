package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.helpers.actions.agent.basics.HealthCheckActions;
import com.symphony.qa.integration.agent.basics.steps.BasicSteps;
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
@Execution(ExecutionMode.CONCURRENT)
//@RunWith(Cucumber.class)
//@CucumberOptions(features = { "src/test/resources/features" })
public class BasicTest {

//    @Test
//    @DisplayName("test Health V2")
//    @Description("This scenario is an example of Actions capabilities")
//    @Story("Health Checks")
//    public void testHealthV2() {
//        HealthCheckActions healthCheckActions = new HealthCheckActions();
//        Response getHealthCheckResponse = healthCheckActions.IRetrieveV2HealthCheckEndpoint();
//        healthCheckActions.IAssertAllV2HealthCheckSuccessfulFields(getHealthCheckResponse);
//    }

    @Test
    @DisplayName("Test Health V2 (First)")
    @Description("This scenario is an example of Cucumber capabilities")
    @Story("Health_Checks")
    @Issue("PLAT-10399")
    public void testHealthV2First() {
        BasicSteps basicSteps = new BasicSteps();
        Response healthCheckResponse;
        healthCheckResponse = basicSteps.IRetrieveAResponseFromTheV2HealthCheckEndpoint(200);
        healthCheckResponse.prettyPeek();
    }

    @Test
    @DisplayName("Test Health V2 (Second)")
    @Description("This scenario is an example of Cucumber capabilities")
    @Story("Health_Checks")
    @Issue("PLAT-10442")
    public void testHealthV2Second() {
        BasicSteps basicSteps = new BasicSteps();
        Response healthCheckResponse;
        healthCheckResponse = basicSteps.IRetrieveAResponseFromTheV2HealthCheckEndpoint(200);
        healthCheckResponse.prettyPeek();
    }

    @Test
    @DisplayName("Test Health V2 (Third)")
    @Description("This scenario is an example of Cucumber capabilities")
    @Story("Health_Checks")
    @Issue("PLAT-10442")
    public void testHealthV2Third() {
        BasicSteps basicSteps = new BasicSteps();
        Response healthCheckResponse;
        healthCheckResponse = basicSteps.IRetrieveAResponseFromTheV2HealthCheckEndpoint(200);
        healthCheckResponse.prettyPeek();
    }

}
