package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class RockChoice extends Choice {

    public RockChoice() {
        choiceOption = ChoiceOption.ROCK;
    }

    @Override
    public Outcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.getChoiceOption()) {
            case PAPER:
                return Outcome.LOSES;
            case SCISSORS:
                return Outcome.BEATS;
            case ROCK:
                return Outcome.TIE;
            default:
                throw new RuntimeException();
        }
    }

}
