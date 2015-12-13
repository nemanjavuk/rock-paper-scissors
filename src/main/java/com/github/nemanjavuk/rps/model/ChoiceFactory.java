package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja on 12/13/15.
 */
public class ChoiceFactory {

    public static Choice createChoice(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("input must be a first letter of a choice");
        }
        if ("r".equalsIgnoreCase(input)) {
            return new RockChoice();
        } else if ("p".equalsIgnoreCase(input)) {
            return new PaperChoice();
        } else if ("s".equalsIgnoreCase(input)) {
            return new ScissorsChoice();
        } else {
            throw new RuntimeException("Wrong input, try again");
        }
    }

    public static Choice createChoice(ChoiceOption choiceOption) {
        if (choiceOption == null) {
            throw new NullPointerException("valid input needed");
        }
        switch (choiceOption) {
            case ROCK:
                return new RockChoice();
            case PAPER:
                return new PaperChoice();
            case SCISSORS:
                return new ScissorsChoice();
            default:
                throw new RuntimeException("I don't know what to create");
        }
    }
}
