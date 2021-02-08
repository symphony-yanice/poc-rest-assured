package com.symphony.qa.helpers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class JsonDataHelper {

    @Step("Check that {fieldName} is equal to: {expected}")
    public static void assertEquals(String fieldName, String actual, String expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check that {fieldName} is equal to: {expected}")
    public static void assertEquals(String fieldName, int actual, int expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check that {fieldName} is equal to: {expected}")
    public static void assertEquals(String fieldName, boolean actual, boolean expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    @Step("Check that {fieldName} is True")
    public static void assertTrue(String fieldName, boolean actual) {
        Assertions.assertTrue(actual, "The result should be: True");
    }

    @Step("Check that {fieldName} is True")
    public static void assertFalse(String filedName, boolean actual) {
        Assertions.assertFalse(actual, "The result should be: False");
    }

}
