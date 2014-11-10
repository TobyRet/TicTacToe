package com.codurance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    public String requestGameType() throws IOException {
        System.out.println("" +
                "TIC TAC TOE\n" +
                "-----------\n\n" +
                "Please select [M]ultiplayer game or [S]ingleplayer game");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        return userInput.readLine();
    }

    public void printBoard(String board) {
        System.out.println(board);
    }

    public String requestNextMove(Player currentPlayer) throws IOException {
        System.out.println(currentPlayer.getName() + "'s turn\n");
        System.out.print(">> ");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        return userInput.readLine();
    }

    public void printWinner(Player player) {
        System.out.println("\n-----------------------");
        System.out.println(player.getName() + " is the winner!");
        System.out.println("-----------------------");

    }
}
