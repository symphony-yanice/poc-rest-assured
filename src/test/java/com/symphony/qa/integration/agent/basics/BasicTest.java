package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.helpers.HttpResponseHelper;
import com.symphony.qa.helpers.JsonDataHelper;
import com.symphony.qa.integration.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Agent")
@Feature("Basics")
@Story("Health Checks")
@Execution(ExecutionMode.CONCURRENT)
public class BasicTest extends BaseTest {

    @Test
    @DisplayName("test Health V2")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealthV2() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

}
