package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class ScissorsChoice extends Choice {

    public ScissorsChoice() {
        choiceOption = ChoiceOption.SCISSORS;
    }

    @Override
    public Outcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.getChoiceOption()) {
            case SCISSORS:
                return Outcome.TIE;
            case ROCK:
                return Outcome.LOSES;
            case PAPER:
                return Outcome.BEATS;
            default:
                throw new RuntimeException();
        }
    }
}
