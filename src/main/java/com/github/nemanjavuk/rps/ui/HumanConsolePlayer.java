package com.github.nemanjavuk.rps.ui;

import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.model.PlayCommandFactory;
import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;

/**
 * Created by nemanja.
 */
public class HumanConsolePlayer implements Player {

    private PlayCommandFactory playCommandFactory;
    private InputDevice keyboard;

    public HumanConsolePlayer(InputDevice keyboard, PlayCommandFactory playCommandFactory) {
        this.keyboard = keyboard;
        this.playCommandFactory = playCommandFactory;
    }

    @Override
    public PlayCommand nextMove() {
        String nextMove = keyboard.next();
        if (nextMove == null || nextMove.isEmpty()) {
            throw new InvalidInputException("Wrong input, please try again");
        }
        return playCommandFactory.createPlayCommandFromInput(nextMove);
    }

    @Override
    public boolean isHumanPlayer() {
        return true;
    }
}
