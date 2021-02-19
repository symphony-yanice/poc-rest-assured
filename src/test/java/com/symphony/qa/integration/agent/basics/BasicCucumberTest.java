package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.integration.BaseTest;
import com.symphony.qa.integration.agent.basics.steps.BasicCucumberSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Agent")
@Feature("Basics")
@Story("Health Checks")
@Execution(ExecutionMode.CONCURRENT)
public class BasicCucumberTest extends BaseTest {

    @Test
    @DisplayName("test Health V2")
    public void testCucumber1() throws Throwable {
        BasicCucumberSteps basicCucumberSteps = new BasicCucumberSteps();
        basicCucumberSteps.firstDigit(5);
        basicCucumberSteps.check(10, 5+5);
    }

}
