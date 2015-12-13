package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class ScissorsChoice extends Choice {

    public ScissorsChoice() {
        choiceOption = ChoiceOption.SCISSORS;
    }

    @Override
    public BattleOutcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.choiceOption) {
            case SCISSORS:
                return BattleOutcome.TIE;
            case ROCK:
                return BattleOutcome.LOSES;
            case PAPER:
                return BattleOutcome.BEATS;
            default:
                throw new RuntimeException();
        }
    }
}
