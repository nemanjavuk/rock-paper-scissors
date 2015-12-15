package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidGameStateException;

/**
 * Created by nemanja.
 */
public class Game {

    private int numOfTurns;
    private int player1Wins;
    private int player2Wins;
    private int ties;

    public void finishTurn(PlayCommand player1Command, PlayCommand player2Command) {
        if (player1Command != null && player2Command != null) {
            BattleOutcome outcome = player1Command.getWeaponOfChoice().compare(player2Command.getWeaponOfChoice());
            numOfTurns++;
            switch (outcome) {
                case BEATS:
                    player1Wins++;
                    break;
                case LOSES:
                    player2Wins++;
                    break;
                case TIE:
                    ties++;
                    break;
            }
        } else {
            throw new InvalidGameStateException("wait for all players to make their choice");
        }
    }

    public int getNumOfTurns() {
        return numOfTurns;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getTies() {
        return ties;
    }

    @Override
    public String toString() {
        return "Game{" +
                "numOfTurns=" + numOfTurns +
                ", player1Wins=" + player1Wins +
                ", player2Wins=" + player2Wins +
                ", ties=" + ties +
                '}';
    }
}
