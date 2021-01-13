package com.symphony.qa.helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class JsonDataHelper {

    @Step("Check the equality of Actual: {actual} and Expected: {expected}")
    public static void assertEquals(String actual, String expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check the equality of Actual: {actual} and Expected: {expected}")
    public static void assertEquals(int actual, int expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check the equality of Actual: {actual} and Expected: {expected}")
    public static void assertEquals(boolean actual, boolean expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check that Actual: {actual} is True")
    public static void assertTrue(boolean actual) {
        Assertions.assertTrue(actual, "The result should be: True");
    }

    @Step("Check that Actual: {actual} is False")
    public static void assertFalse(boolean actual) {
        Assertions.assertFalse(actual, "The result should be: False");
    }

}
