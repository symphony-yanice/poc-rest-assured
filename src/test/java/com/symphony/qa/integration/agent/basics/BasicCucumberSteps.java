package com.symphony.qa.integration.agent.basics;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BasicCucumberSteps {
    int a;
    int b;
    int c;
    int sum;

    @Given("^first digit (\\d+)$")
    public void firstDigit(int digit) throws Throwable {
        a = digit;
    }

    @And("^second digit (\\d+)$")
    public void secondDigit(int digit) throws Throwable {
        b = digit;
    }

    public void thirdDigit(int digit) throws Throwable {
        c = digit;
    }

    @When("^I multiply it$")
    public void multiply() throws Throwable {
        sum = a + b + c;
    }

    @Then("^sum is (\\d+)$")
    public void sum(int result) throws Throwable {
        Assert.assertEquals(result, sum);
    }

}
