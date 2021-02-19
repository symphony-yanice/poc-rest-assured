package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.integration.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;

@Epic("Agent")
@Feature("Basics")
@Story("Multiple Health Checks")
@Execution(ExecutionMode.CONCURRENT)
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/agent"}
)
public class MultipleBasicTest extends BaseTest {

}
