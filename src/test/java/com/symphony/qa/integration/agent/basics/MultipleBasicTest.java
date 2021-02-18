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
@Story("Multiple Health Checks")
@Execution(ExecutionMode.CONCURRENT)
public class MultipleBasicTest extends BaseTest {

    @Test
    @DisplayName("Basic test 1")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 2")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth2() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 3")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth3() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 4")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth4() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 5")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth5() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 6")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth6() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 7")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth7() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 8")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth8() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 9")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth9() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @DisplayName("Basic test 10")
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth10() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(r -> r);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue("podConnectivity", getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue("keyManagerConnectivity", getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue("encryptDecryptSuccess", getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals("podVersion", getResponse.getBody().path("podVersion"), System.getenv("AUTOMATED_POD_VERSION"));
        JsonDataHelper.assertEquals("agentVersion", getResponse.getBody().path("agentVersion"), System.getenv("AUTOMATED_AGENT_VERSION"));
        JsonDataHelper.assertTrue("agentServiceUser", getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue("ceServiceUser", getResponse.getBody().path("ceServiceUser"));
    }

}
