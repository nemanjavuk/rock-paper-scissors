package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja.
 */
public class Player {

    private Choice madeChoice;

    public void makeChoice(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("input must be a first letter of a choice");
        }
        if ("r".equalsIgnoreCase(input)) {
            madeChoice = new RockChoice();
        } else if ("p".equalsIgnoreCase(input)) {
            madeChoice = new PaperChoice();
        } else if ("s".equalsIgnoreCase(input)) {
            madeChoice = new ScissorsChoice();
        } else {
            throw new RuntimeException("try again");
        }
    }

    public Outcome compareAgainst(Player otherPlayer) {
        if (otherPlayer == null) {
            throw new NullPointerException("otherPlayer can't be null");
        }
        return madeChoice.compare(otherPlayer.madeChoice);
    }


}
