package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class RockChoice extends Choice {

    public RockChoice() {
        choiceOption = ChoiceOption.ROCK;
    }

    @Override
    public BattleOutcome compare(Choice otherChoice) {
        if (otherChoice == null) {
            throw new NullPointerException();
        }
        switch (otherChoice.choiceOption) {
            case PAPER:
                return BattleOutcome.LOSES;
            case SCISSORS:
                return BattleOutcome.BEATS;
            case ROCK:
                return BattleOutcome.TIE;
            default:
                throw new RuntimeException();
        }
    }

}
