package com.github.nemanjavuk.rps;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Player player1 = new Player();
        player1.makeChoice("p");
        Player player2 = new Player();
        player2.makeChoice("s");

        player1.compareAgainst(player2);
    }
}
