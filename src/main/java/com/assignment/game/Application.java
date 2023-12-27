package com.assignment.game;

import com.assignment.game.service.GameServiceImpl;

public class Application {
    public static final int NO_OF_BOXES = 3;
    public static final int NO_OF_SIMULATIONS = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < NO_OF_SIMULATIONS; i++) {
            var result = new GameServiceImpl(NO_OF_BOXES)
                    .run();
            System.out.println("Round result is" + result);
        }
    }
}
