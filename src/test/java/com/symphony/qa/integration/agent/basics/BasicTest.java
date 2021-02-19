package com.symphony.qa.integration.agent.basics;

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
@Story("Health Checks")
@Execution(ExecutionMode.CONCURRENT)
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/agent"}
)
public class BasicTest {

    @Test
    @DisplayName("test Health V2")
    @Description("This scenario is an example of Allure capabilities with cucumber")
    @Issue("PLAT-10399")
    public void testHealthV2() {
        BasicSteps basicSteps = new BasicSteps();
        Response getHealthCheck = basicSteps.thatIRetrieveAResponseFromTheHealthEndpoint();
        basicSteps.iReceiveAStatusCodeFromA(getHealthCheck, 200);
        basicSteps.allTheVHealthCheckFieldsArePresent(getHealthCheck);
    }

}
