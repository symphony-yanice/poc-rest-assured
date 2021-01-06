package com.symphony.qa.integration.agent.basics;

import com.symphony.qa.helpers.HttpResponseHelper;
import com.symphony.qa.helpers.JsonDataHelper;
import com.symphony.qa.integration.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Epic("Agent")
@Feature("Basics")
@Story("Health Checks")
@Execution(ExecutionMode.CONCURRENT)
public class BasicTest2 extends BaseTest {

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth2() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth3() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth4() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth5() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth6() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth7() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth8() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth9() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

    @Test
    @Description("**Scenario** : Example of a BDD Scenario<br/><br/>" +
            "*Given* that I connect to the Agent API<br/>" +
            "*When* I check the health of the endpoint<br/>" +
            "*Then* I expect to have a successful answer<br/>")
    public void testHealth10() {
        Response getResponse = this.systemApi.v2HealthCheckGet().execute(ResponseBody::prettyPeek);
        HttpResponseHelper.assertStatusCode(getResponse, 200);
        JsonDataHelper.assertTrue(getResponse.getBody().path("podConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("keyManagerConnectivity"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("encryptDecryptSuccess"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("podVersion"), this.config.getProperty("pod.version"));
        JsonDataHelper.assertEquals(getResponse.getBody().path("agentVersion"), this.config.getProperty("agent.version"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("agentServiceUser"));
        JsonDataHelper.assertTrue(getResponse.getBody().path("ceServiceUser"));
    }

}
