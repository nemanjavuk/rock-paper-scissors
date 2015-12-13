package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class PaperChoice extends Choice {

    public PaperChoice() {
        choiceOption = ChoiceOption.PAPER;
    }

    @Override
    public Outcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.getChoiceOption()) {
            case PAPER:
                return Outcome.TIE;
            case ROCK:
                return Outcome.BEATS;
            case SCISSORS:
                return Outcome.LOSES;
            default:
                throw new RuntimeException();
        }
    }


}
