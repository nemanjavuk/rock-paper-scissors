package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class PaperChoice extends Choice {

    public PaperChoice() {
        choiceOption = ChoiceOption.PAPER;
    }

    @Override
    public BattleOutcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.choiceOption) {
            case PAPER:
                return BattleOutcome.TIE;
            case ROCK:
                return BattleOutcome.BEATS;
            case SCISSORS:
                return BattleOutcome.LOSES;
            default:
                throw new RuntimeException();
        }
    }


}
