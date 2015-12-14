package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class PlayCommandFactory {

    public static PlayCommand createPlayCommandFromInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Wrong input, try again");
        }
        return new PlayCommand(input);
    }

    public static PlayCommand createRandomPlayCommand() {
        return new PlayCommand();
    }
}
