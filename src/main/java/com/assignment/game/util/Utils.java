package com.assignment.game.util;

import java.util.Random;

public class Utils {

    public static int getRandomNumber(int numberOfBoxes) {
        return new Random().nextInt(numberOfBoxes);
    }

    public static boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }
}
