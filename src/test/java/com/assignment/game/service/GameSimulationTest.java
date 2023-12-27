package com.assignment.game.service;

import com.assignment.game.model.Result;
import com.assignment.game.model.RoundDetail;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameSimulationTest {
    private GameService gameService;
    private static final Integer NO_OF_BOXES = 3;
    private static final Integer NO_OF_SIMULATIONS = 10000;

    @Test
    public void testWinningPercentageWithSwitch() {
        long totalWinsWithSwitch = 0;
        long noOfSwitches = 0;
        List<RoundDetail> results = new ArrayList<>();
        for (int i = 0; i < NO_OF_SIMULATIONS; i++) {
            gameService = new GameServiceImpl(NO_OF_BOXES);
            results.add(gameService.run());
            totalWinsWithSwitch += results.stream().filter(result -> result.getResult().equals(Result.WON) && result.isHasSwitchedBox()).count();
            noOfSwitches += results.stream().filter(result -> result.isHasSwitchedBox()).count();

        }
        var winningPercentage = ((double) totalWinsWithSwitch / noOfSwitches) * 100;
        assertEquals(66.67, winningPercentage, 2); // Allow a 2.0% tolerance for randomness
    }

    @Test
    public void testWinningPercentageWithoutSwitch() {
        long totalWinsWithoutSwitch = 0;
        long noOfNoSwitches = 0;
        List<RoundDetail> results = new ArrayList<>();
        for (int i = 0; i < NO_OF_SIMULATIONS; i++) {
            gameService = new GameServiceImpl(NO_OF_BOXES);
            results.add(gameService.run());
            totalWinsWithoutSwitch += results.stream().filter(result -> result.getResult().equals(Result.WON) && !result.isHasSwitchedBox()).count();
            noOfNoSwitches += results.stream().filter(result -> !result.isHasSwitchedBox()).count();

        }
        var winningPercentage = ((double) totalWinsWithoutSwitch / noOfNoSwitches) * 100;
        assertEquals(33.33, winningPercentage, 2); // Allow a 2.0% tolerance for randomness
    }
}
