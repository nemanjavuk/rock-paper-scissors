package com.github.nemanjavuk.rps.model;

import com.github.nemanjavuk.rps.model.exceptions.InvalidGameStateException;

/**
 * Created by nemanja.
 */

public class Game {

    private boolean gameFinished;
    private int numOfTurns;
    private int player1Wins;
    private int player2Wins;
    private int ties;
    private TurnOutcome lastTurnOutcome;

    public TurnOutcome finishTurn(PlayCommand player1Command, PlayCommand player2Command) {
        if (!gameFinished) {
            if (player1Command != null && player2Command != null) {
                BattleOutcome outcome = player1Command.getWeaponOfChoice().compare(player2Command.getWeaponOfChoice());
                numOfTurns++;
                switch (outcome) {
                    case BEATS:
                        player1Wins++;
                        lastTurnOutcome = new TurnOutcome(player1Command.getWeaponOfChoice(), "Player 1");
                        break;
                    case LOSES:
                        player2Wins++;
                        lastTurnOutcome = new TurnOutcome(player2Command.getWeaponOfChoice(), "Player 2");
                        break;
                    case TIE:
                        ties++;
                        lastTurnOutcome = new TurnOutcome();
                        break;
                }
            } else {
                throw new InvalidGameStateException("wait for all players to make their choice");
            }
        }
        return lastTurnOutcome;
    }

    public TurnOutcome finishGame() {
        this.gameFinished = true;
        return lastTurnOutcome;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public int getPlayer1Wins() {
        return player1Wins;
    }

    public int getPlayer2Wins() {
        return player2Wins;
    }

    public int getNumOfTurns() {
        return numOfTurns;
    }

    public int getTies() {
        return ties;
    }


    @Override
    public String toString() {
        if (gameFinished) {
            return "Game is finished. Player 1 has " + player1Wins + " hands won and Player 2 has "
                    + player2Wins + " hands won. There were " + ties + " ties.";
        } else {
            return "Current state after " + numOfTurns + " number of turns is: " +
                    "Player 1: " + player1Wins + " won hands. Player 2: " + player2Wins + " won hands. "
                    + "There are " + ties + " ties.";
        }
    }

}
