package com.github.nemanjavuk.rps.ui;

import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.model.PlayCommandFactory;

import java.util.Scanner;

/**
 * Created by nemanja on 12/14/15.
 */
public class HumanConsolePlayer implements Player {

    private Scanner keyboard;

    public HumanConsolePlayer(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public PlayCommand nextMove() {
        String nextMove = keyboard.next();
        return PlayCommandFactory.createPlayCommandFromInput(nextMove);
    }
}
