package com.symphony.qa.helpers;

import org.junit.jupiter.api.Assertions;

public class JsonDataHelper {

    public static void assertEquals(String actual, String expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    public static void assertEquals(int actual, int expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    public static void assertEquals(boolean actual, boolean expected) {
        Assertions.assertEquals(actual, expected, "The expected result should be: " + expected);
    }

    public static void assertTrue(boolean actual) {
        Assertions.assertTrue(actual, "The result should be: True");
    }

    public static void assertFalse(boolean actual) {
        Assertions.assertFalse(actual, "The result should be: False");
    }

}
