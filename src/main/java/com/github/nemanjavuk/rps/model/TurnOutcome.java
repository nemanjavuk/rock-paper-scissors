package com.github.nemanjavuk.rps.model;

/**
 * Created by nemanja on 12/16/15.
 */
public class TurnOutcome {

    private Weapon winnerWeapon;
    private String winnerName;
    private boolean tie;

    public TurnOutcome() {
        this.tie = true;
        this.winnerName = "No one";
    }

    public TurnOutcome(Weapon winnerWeapon, String winnerName) {
        this.winnerWeapon = winnerWeapon;
        this.winnerName = winnerName;
    }

    public Weapon getWinnerWeapon() {
        return winnerWeapon;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public boolean isTie() {
        return tie;
    }
}
