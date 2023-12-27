package com.assignment.game.service;

import com.assignment.game.model.Box;
import com.assignment.game.model.Result;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.assignment.game.model.Result.LOST;
import static com.assignment.game.model.Result.WON;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {
    private GameService gameService;
    private static final Integer NO_OF_BOXES = 3;

    @Before
    public void init() {
        gameService = new GameServiceImpl(NO_OF_BOXES);
    }

    @Test
    public void test_decidePrizeBox() {
        Box prizeBox = gameService.decidePrizeBox();
        assertEquals(Boolean.TRUE, prizeBox.isHasPrize());
    }


    @Test
    public void test_determineResult_Won() {
        Box userChoiceBox = new Box();
        userChoiceBox.setHasPrize(Boolean.TRUE);
        Result result = gameService.determineResult(userChoiceBox);
        assertEquals(WON.name(), result.name());
    }

    @Test
    public void test_determineResult_Lost() {
        Box userChoiceBox = new Box();
        userChoiceBox.setUserSelected(Boolean.TRUE);
        Result result = gameService.determineResult(userChoiceBox);
        assertEquals(LOST.name(), result.name());
    }
}
