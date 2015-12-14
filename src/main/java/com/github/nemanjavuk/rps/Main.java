package com.github.nemanjavuk.rps;

import com.github.nemanjavuk.rps.model.Game;
import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.ui.ComputerPlayer;
import com.github.nemanjavuk.rps.ui.HumanConsolePlayer;
import com.github.nemanjavuk.rps.ui.Player;
import com.github.nemanjavuk.rps.util.Constants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println(Constants.WELCOME);

        boolean startNewGame = true;

        while (startNewGame) {
            startNewGame = false;

            boolean invalidGameType = true;
            while (invalidGameType) {
                System.out.println(Constants.GAME_TYPE_CHOSER);
                String gameType = keyboard.next();
                if ("h".equalsIgnoreCase(gameType)) {
                    //H vs C game
                    invalidGameType = true;
                    Scanner userKeyboard = new Scanner(System.in);
                    Player player1 = new HumanConsolePlayer(userKeyboard);
                    Player player2 = new ComputerPlayer();
                    playGame(keyboard, player1, player2, true);
                } else if ("c".equalsIgnoreCase(gameType)) {
                    //C vs C game
                    invalidGameType = true;
                    Player player1 = new ComputerPlayer();
                    Player player2 = new ComputerPlayer();
                    playGame(keyboard, player1, player2, false);
                } else if ("q".equalsIgnoreCase(gameType)) {
                    System.out.println(Constants.BYE);
                    System.exit(0);
                } else {
                    System.out.println(Constants.WRONG_INPUT);
                }
            }
        }
    }

//    private static void humanVsCompGame(Scanner keyboard) {
//        boolean goForAnotherTurn = true;
//        Game hVCGame = new Game();
//        System.out.println(Constants.SMARTY_H_V_C_INTRO);
//        Scanner userKeyboard = new Scanner(System.in);
//        Player player1 = new HumanConsolePlayer(userKeyboard);
//        Player player2 = new ComputerPlayer();
//        while (goForAnotherTurn) {
//            System.out.println("Enter [R]ock, [P]aper or [S]cissors");
//
//            PlayCommand player1Move = null;
//            boolean validMove = false;
//            while (!validMove) {
//                try {
//                    player1Move = player1.nextMove();
//                    validMove = true;
//                } catch (RuntimeException rte) {
//                    System.out.println(Constants.WRONG_INPUT);
//                }
//            }
//            PlayCommand player2Move = player2.nextMove();
//
//            System.out.println("Computer chose " + player2Move.getWeaponOfChoice().toString());
//
//            hVCGame.finishTurn(player1Move, player2Move);
//
//            System.out.println(hVCGame);
//            System.out.println(Constants.GO_FOR_ANOTHER_TURN);
//
//            boolean invalidHVCResponse = true;
//            while (invalidHVCResponse) {
//                String continueHVCText = keyboard.next();
//                if ("n".equalsIgnoreCase(continueHVCText)) {
//                    System.out.println(Constants.OK_AS_YOU_WISH);
//                    System.out.println("Final result is " + hVCGame);
//                    invalidHVCResponse = false;
//                    goForAnotherTurn = false;
//                } else if ("y".equalsIgnoreCase(continueHVCText)) {
//                    System.out.println(Constants.LET_S_GO_FOR_ANOTHER_TURN);
//                    invalidHVCResponse = false;
//                } else {
//                    System.out.println("wrong input, try again");
//                }
//            }
//        }
//    }
//
//    private static void compVsCompGame(Scanner keyboard) {
//        boolean goForAnotherTurn = true;
//        Game cVCGame = new Game();
//        System.out.println(Constants.SMARTY_C_V_C_INTRO);
//        Player player1 = new ComputerPlayer();
//        Player player2 = new ComputerPlayer();
//        while (goForAnotherTurn) {
//            PlayCommand player1Move = player1.nextMove();
//            PlayCommand player2Move = player2.nextMove();
//
//            cVCGame.finishTurn(player1Move, player2Move);
//
//            System.out.println(cVCGame);
//
//            System.out.println(Constants.GO_FOR_ANOTHER_TURN);
//
//            boolean invalidCVCResponse = true;
//            while (invalidCVCResponse) {
//                String continueCVCText = keyboard.next();
//                if ("n".equalsIgnoreCase(continueCVCText)) {
//                    System.out.println(Constants.OK_AS_YOU_WISH);
//                    System.out.println("Final result is " + cVCGame);
//                    invalidCVCResponse = false;
//                    goForAnotherTurn = false;
//                } else if ("y".equalsIgnoreCase(continueCVCText)) {
//                    System.out.println(Constants.LET_S_GO_FOR_ANOTHER_TURN);
//                    invalidCVCResponse = false;
//                } else {
//                    System.out.println("wrong input, try again");
//                }
//            }
//        }
//    }

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
                    } catch (RuntimeException rte) {
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
                if ("n".equalsIgnoreCase(continueText)) {
                    System.out.println(Constants.OK_AS_YOU_WISH);
                    System.out.println(Constants.FINAL_RESULT_IS + game);
                    invalidResponse = false;
                    goForAnotherTurn = false;
                } else if ("y".equalsIgnoreCase(continueText)) {
                    System.out.println(Constants.LET_S_GO_FOR_ANOTHER_TURN);
                    invalidResponse = false;
                } else {
                    System.out.println(Constants.WRONG_INPUT);
                }
            }
        }


    }
}
