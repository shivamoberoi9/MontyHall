package com.assignment.game.service;

import com.assignment.game.model.Box;
import com.assignment.game.model.Result;
import com.assignment.game.model.RoundDetail;
import com.assignment.game.util.Utils;

public abstract class GameService {
    public abstract Box decidePrizeBox();

    public abstract Box getUserChoice();

    public abstract void selectEmptyBoxToOpen();

    public abstract Box getOtherBox(Box userChoiceBox);

    public abstract Result determineResult(Box userChoiceBox);

    public RoundDetail run() {
        decidePrizeBox();
        var userChoiceBox = getUserChoice();
        selectEmptyBoxToOpen();
        var hasSwitchedBox = Utils.getRandomBoolean();
        if (hasSwitchedBox) {
            userChoiceBox = getOtherBox(userChoiceBox);
        }
        var result = determineResult(userChoiceBox);
        var gameDetail = RoundDetail.builder().result(result).hasSwitchedBox(hasSwitchedBox).build();
        return gameDetail;
    }
}
