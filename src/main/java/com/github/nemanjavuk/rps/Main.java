package com.github.nemanjavuk.rps;

import com.github.nemanjavuk.rps.model.Game;
import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.model.PlayCommandFactory;
import com.github.nemanjavuk.rps.model.WeaponFactory;
import com.github.nemanjavuk.rps.model.exceptions.InvalidInputException;
import com.github.nemanjavuk.rps.ui.*;
import com.github.nemanjavuk.rps.util.Constants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println(Constants.WELCOME);

        boolean startNewGame = true;

        WeaponFactory weaponFactory = new WeaponFactory();
        PlayCommandFactory playCommandFactory = new PlayCommandFactory(weaponFactory);

        while (startNewGame) {
            startNewGame = false;

            boolean invalidGameType = true;
            while (invalidGameType) {
                System.out.println(Constants.GAME_TYPE_CHOSER);
                String gameType = keyboard.next();
                if (Constants.HUMAN_VS_COMPUTER.equalsIgnoreCase(gameType)) {
                    //H vs C game
                    invalidGameType = true;
                    Scanner userKeyboard = new Scanner(System.in);
                    InputDevice inputDevice = new KeyboardInput(userKeyboard);
                    Player player1 = new HumanConsolePlayer(inputDevice, playCommandFactory);
                    Player player2 = new ComputerPlayer(playCommandFactory);
                    playGame(keyboard, player1, player2, true);
                } else if (Constants.COMPUTER_VS_COMPUTER.equalsIgnoreCase(gameType)) {
                    //C vs C game
                    invalidGameType = true;
                    Player player1 = new ComputerPlayer(playCommandFactory);
                    Player player2 = new ComputerPlayer(playCommandFactory);
                    playGame(keyboard, player1, player2, false);
                } else if (Constants.QUIT.equalsIgnoreCase(gameType)) {
                    System.out.println(Constants.BYE);
                    System.exit(0);
                } else {
                    System.out.println(Constants.WRONG_INPUT);
                }
            }
        }
    }

    private static void playGame(Scanner keyboard, Player player1, Player player2, boolean isHumanVsCompGame) {
        boolean goForAnotherTurn = true;
        Game game = new Game();

        if (isHumanVsCompGame) {
            System.out.println(Constants.SMARTY_H_V_C_INTRO);
        } else {
            System.out.println(Constants.SMARTY_C_V_C_INTRO);
        }

        while (goForAnotherTurn) {
            PlayCommand player1Move = null;

            if (isHumanVsCompGame) {
                System.out.println(Constants.CHOOSE_WEAPON);
                boolean validMove = false;
                while (!validMove) {
                    try {
                        player1Move = player1.nextMove();
                        validMove = true;
                    } catch (InvalidInputException iie) {
                        System.out.println(Constants.WRONG_INPUT);
                    }
                }
            } else {
                player1Move = player1.nextMove();
            }

            PlayCommand player2Move = player2.nextMove();

            //TODO:nemanja:add informing who did what move

            game.finishTurn(player1Move, player2Move);

            System.out.println(game);
            System.out.println(Constants.GO_FOR_ANOTHER_TURN);

            boolean invalidResponse = true;
            while (invalidResponse) {
                String continueText = keyboard.next();
                if (Constants.NO.equalsIgnoreCase(continueText)) {
                    System.out.println(Constants.OK_AS_YOU_WISH);
                    System.out.println(Constants.FINAL_RESULT_IS + game);
                    invalidResponse = false;
                    goForAnotherTurn = false;
                } else if (Constants.YES.equalsIgnoreCase(continueText)) {
                    System.out.println(Constants.LET_S_GO_FOR_ANOTHER_TURN);
                    invalidResponse = false;
                } else {
                    System.out.println(Constants.WRONG_INPUT);
                }
            }
        }


    }
}
