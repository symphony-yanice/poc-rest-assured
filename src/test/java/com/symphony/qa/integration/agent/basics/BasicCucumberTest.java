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
@Story("Health_Checks")
@Execution(ExecutionMode.CONCURRENT)
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" })
public class BasicCucumberTest {

//    @Tests

}
