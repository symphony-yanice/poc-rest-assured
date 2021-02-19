package com.symphony.qa.integration.agent.basics.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BasicCucumberSteps {
    int a;
    int b;
    int c;
    int sum;

    @Step("Given that the first digit {digit}")
    @Given("^first digit (\\d+)$")
    public void firstDigit(int digit) throws Throwable {
        a = digit;
    }

    @Step("And that the second digit {digit}")
    @And("^second digit (\\d+)$")
    public void secondDigit(int digit) throws Throwable {
        b = digit;
    }

    public void thirdDigit(int digit) throws Throwable {
        c = digit;
    }

    @Step("When I add {arg0} and {arg1}")
    @When("I add {int} to {int}")
    public void iAddTo(int arg0, int arg1) {
    }
    
    @Step("Then the result {result} is equal to {expected}")
    @Then("^sum is (\\d+)$")
    public void check(int result, int expected) throws Throwable {
        Assert.assertEquals(result, expected);
    }
}
