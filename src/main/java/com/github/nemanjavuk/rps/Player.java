package com.github.nemanjavuk.rps;

import com.github.nemanjavuk.rps.model.Choice;
import com.github.nemanjavuk.rps.model.ChoiceFactory;
import com.github.nemanjavuk.rps.model.BattleOutcome;

/**
 * Created by nemanja.
 */
public class Player {

    protected Choice madeChoice;

    public void makeChoice(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("input must be a first letter of a choice");
        }
        madeChoice = ChoiceFactory.createChoice(input);
    }

    public BattleOutcome compareAgainst(Player otherPlayer) {
        if (otherPlayer == null) {
            throw new NullPointerException("otherPlayer can't be null");
        }
        return madeChoice.compare(otherPlayer.madeChoice);
    }


}
