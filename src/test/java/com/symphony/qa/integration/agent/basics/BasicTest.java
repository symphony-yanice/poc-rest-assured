package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.helpers.actions.agent.basics.HealthCheckActions;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Agent")
@Feature("Basics")
@Story("Health_Checks")
@Execution(ExecutionMode.CONCURRENT)
public class BasicTest {

    @Test
    @DisplayName("test Health V3 with Actions (first)")
    @Description("**Given** I retrieve a 200 response from the V3 health check endpoint<br>" +
            "**Then** all the mandatory successful fields are correctly displayed")
    @Issue("PLAT-10590")
    public void testHealthV3First() {
        HealthCheckActions healthCheckActions = new HealthCheckActions();
        Response getHealthCheckResponse = healthCheckActions.IRetrieveV3HealthCheckEndpoint();
        healthCheckActions.IAssertAllV3HealthCheckSuccessfulFields(getHealthCheckResponse);
    }

    @Test
    @DisplayName("test Health V3 with Actions (second)")
    @Description("**Given** I retrieve a 200 response from the V3 health check endpoint<br>" +
            "**Then** all the mandatory successful fields are correctly displayed")
    @Issue("PLAT-10590")
    @TmsLink("TEST-21182")
    public void testHealthV3Second() {
        HealthCheckActions healthCheckActions = new HealthCheckActions();
        Response getHealthCheckResponse = healthCheckActions.IRetrieveV3HealthCheckEndpoint();
        healthCheckActions.IAssertAllV3HealthCheckSuccessfulFields(getHealthCheckResponse);
    }

    @Test
    @DisplayName("test Health V3 with Actions (third)")
    @Description("**Given** I retrieve a 200 response from the V3 health check endpoint<br>" +
            "**Then** all the mandatory successful fields are correctly displayed")
    @Issue("PLAT-10590")
    public void testHealthV3Third() {
        HealthCheckActions healthCheckActions = new HealthCheckActions();
        Response getHealthCheckResponse = healthCheckActions.IRetrieveV3HealthCheckEndpoint();
        healthCheckActions.IAssertAllV3HealthCheckSuccessfulFields(getHealthCheckResponse);
    }

}
