package com.assignment.game.service;

import com.assignment.game.model.Box;
import com.assignment.game.model.Result;

import static com.assignment.game.model.Result.LOST;
import static com.assignment.game.model.Result.WON;
import static com.assignment.game.util.Utils.getRandomNumber;

public class GameServiceImpl extends GameService {
    private final Box[] boxes;

    public GameServiceImpl(int noOfBoxes) {
        this.boxes = new Box[noOfBoxes];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box();
        }
    }

    @Override
    public Box decidePrizeBox() {
        int boxNumber = getRandomNumber(boxes.length);
        Box prizeBox = boxes[boxNumber];
        prizeBox.setHasPrize(true);
        return prizeBox;
    }

    @Override
    public Box getUserChoice() {
        Box userChoiceBox = boxes[getRandomNumber(boxes.length)];
        userChoiceBox.setUserSelected(true);
        return userChoiceBox;
    }

    @Override
    public void selectEmptyBoxToOpen() {
        int boxNumber = getRandomNumber(boxes.length);
        while (boxes[boxNumber].isHasPrize() || boxes[boxNumber].isUserSelected()) {
            boxNumber = getRandomNumber(boxes.length);
        }
        boxes[boxNumber].setOpened(true);
    }

    @Override
    public Result determineResult(final Box userChoiceBox) {
        return userChoiceBox.isHasPrize() ? WON : LOST;
    }

    @Override
    public Box getOtherBox(Box userSelectedBox) {
        int boxNumber = getRandomNumber(boxes.length);
        while (boxes[boxNumber].isUserSelected() || boxes[boxNumber].isOpened()) {
            boxNumber = getRandomNumber(boxes.length);
        }
        boxes[boxNumber].setUserSelected(true);
        userSelectedBox.setUserSelected(false);
        return boxes[boxNumber];
    }
}
