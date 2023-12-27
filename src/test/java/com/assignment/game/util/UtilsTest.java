package com.assignment.game.util;

import org.junit.BeforeClass;
import org.junit.Test;

import static com.assignment.game.util.Utils.getRandomNumber;
import static org.junit.Assert.assertTrue;

public class UtilsTest {
    private static int numberOfBoxes;

    @BeforeClass
    public static void init() {
        numberOfBoxes = 3;
    }

    @Test
    public void test_getRandomNumber() {
        int outputNumber = getRandomNumber(numberOfBoxes);
        assertTrue(numberOfBoxes > outputNumber);
    }
}
