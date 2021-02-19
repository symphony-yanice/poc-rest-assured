package com.symphony.qa.integration.agent.basics;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Agent")
@Feature("Basics")
@Story("Multiple Health Checks")
@Execution(ExecutionMode.CONCURRENT)
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = {"src/test/resources/features/agent"}
//)
public class MultipleTest {

}
